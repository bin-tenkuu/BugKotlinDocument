package com.github.bin.bugktdoc

import com.github.bin.bugktdoc.constants.*
import com.github.bin.bugktdoc.options.BugKtDocGlobalSettingsObject.settings
import com.intellij.codeInsight.editorActions.CodeDocumentationUtil
import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.lang.LanguageCommenters
import com.intellij.lang.documentation.CodeDocumentationProvider
import com.intellij.lang.documentation.DocumentationProviderEx
import com.intellij.openapi.util.Pair
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.builtins.isBuiltinFunctionalType
import org.jetbrains.kotlin.descriptors.ConstructorDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.resolveToDescriptorIfAny
import org.jetbrains.kotlin.kdoc.psi.api.KDoc
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtConstructor
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.renderer.*
import org.jetbrains.kotlin.resolve.constants.KClassValue
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.starProjectionType

/**
 * @author zxj5470
 * @author bin
 * @date 2018/4/6
 */
class BugKtDocumentationProvider : DocumentationProviderEx(), CodeDocumentationProvider {
	override fun parseContext(startPoint: PsiElement): Pair<PsiElement, PsiComment>? {
		var current: PsiElement? = startPoint
		while (current !== null) {
			if (current is KDoc) {
				return Pair(current, current)
			}
			current = current.parent
		}
		return null
	}

	override fun generateDocumentationContentStub(contextComment: PsiComment?): String? {
		if (!settings.useDoc || contextComment === null) return null
		val prefix = contextComment.getDocPrefix()
		return when (val owner = contextComment.parent ?: return null) {
			is KtNamedFunction -> {
				if (!settings.useFunctionDoc) null
				else docKtNamedFunction(owner, prefix)
			}
			is KtClass -> {
				if (!settings.useClassDoc) null
				else docKtClass(owner, prefix)
			}
			is KtConstructor<*> -> {
				if (!settings.useConstructorDoc) null
				else docKtConstructor(owner, prefix)
			}
			else -> null
		}
	}

	override fun findExistingDocComment(contextElement: PsiComment?): PsiComment? =
		(contextElement as? KDoc)?.owner?.docComment ?: contextElement

	private fun docKtNamedFunction(owner: KtNamedFunction, prefix: String): String? = buildString {
		val type = owner.resolveToDescriptorIfAny() ?: return null

		if (settings.funGeneric) {
			for (it in type.typeParameters) {
				appendDoc(prefix, PARAM, it.name.asString(), it.starProjectionType())
			}
		}

		if (settings.funContext) {
			for (parameter in type.contextReceiverParameters) {
				appendDoc(prefix, CONTEXT_RECEIVER, parameter.type)
			}
		}

		// @receiver
		if (settings.funReceiver) {
			type.extensionReceiverParameter?.let {
				appendDoc(prefix, RECEIVER, it.type)
			}
		}

		// @param
		if (settings.funParam) {
			for (parameter in type.valueParameters) {
				appendDoc(prefix, PARAM, parameter.name.asString(), parameter.type)
			}
		}

		// @return
		if (settings.funReturn) {
			val returnType = type.returnType!!
			if (settings.alwaysShowUnitReturnType
				|| owner.hasDeclaredReturnType()
				|| returnType.isMarkedNullable
				|| returnType.toString() != "Unit"
			) {
				appendDoc(prefix, RETURN, returnType)
			}
		}

		// @throws
		if (settings.funThrows) {
			type.annotations.findAnnotation(FqName("kotlin.jvm.Throws"))?.let {
				it.allValueArguments[Name.identifier("exceptionClasses")]?.value as? List<*>
			}?.let {
				for (any in it) {
					val kClassValue = any as? KClassValue ?: continue
					val kotlinType = kClassValue.getArgumentType(type.module)
					appendDoc(prefix, THROWS, kotlinType)
				}
			}
		}
	}

	private fun docKtClass(owner: KtClass, prefix: String): String? = buildString {
		val type = owner.resolveToDescriptorIfAny() ?: return null

		if (settings.classGeneric) {
			for (parameter in type.declaredTypeParameters) {
				appendDoc(prefix, PARAM, parameter.name.asString(), parameter.starProjectionType())
			}
		}

		// @param
		if (settings.classParam) {
			val constructorType = type.constructors.find { it.isPrimary }
			if (constructorType != null) {
				for (parameter in constructorType.valueParameters) {
					appendDoc(prefix, PARAM, parameter.name.asString(), parameter.type)
				}
			}
		}

//		// order: 1. primary Parameters -> @property
//		if (Settings.classProperty) {
//			appendDoc(prefix, PROPERTY, owner.primaryConstructorParameters.filter { it.hasValOrVar() })
//		}

		// order: 2. class fields -> @property
		if (settings.classProperty) {
			for (it in owner.getProperties()) {
				val descriptor = it.resolveToDescriptorIfAny() ?: continue
				appendDoc(prefix, PROPERTY, descriptor.name.asString(), descriptor.type)
			}
		}

		// @constructor
		if (settings.classConstructor) {
			append(prefix).append(CONSTRUCTOR).appendLine()
		}
	}

	private fun docKtConstructor(owner: KtConstructor<*>, prefix: String): String? = buildString {
		val type = owner.resolveToDescriptorIfAny() as? ConstructorDescriptor ?: return null

		// @param
		if (settings.constructorParam) {
			for (parameter in type.valueParameters) {
				appendDoc(prefix, PARAM, parameter.name.asString(), parameter.type)
			}
		}

		// @constructor
		if (settings.constructorConstructor) {
			append(prefix).append(CONSTRUCTOR).appendLine()
		}
	}

	private fun PsiComment.getDocPrefix(): String = CodeDocumentationUtil.createDocCommentLine(
		"", containingFile, LanguageCommenters.INSTANCE.forLanguage(language) as CodeDocumentationAwareCommenter
	)

	private fun StringBuilder.appendDoc(prefix: String, type: String, ktType: KotlinType) {
		append(prefix).append(type).append(' ').appendDoc(ktType).appendLine()
	}

	private fun StringBuilder.appendDoc(prefix: String, type: String, name: String, ktType: KotlinType) {
		append(prefix).append(type).append(' ').append(name).append(' ').appendDoc(ktType).appendLine()
	}

	private fun StringBuilder.appendDoc(type: KotlinType): StringBuilder {
		if (!settings.showBuiltinType || !type.isBuiltinFunctionalType || type.arguments.isEmpty()) {
			append(descriptorRenderer.renderType(type))
		}
		else {
			val nullable = type.isMarkedNullable
			if (nullable) {
				append('(')
			}
			append(type.constructor)
			append("<")
			var notFirst = false
			for (argument in type.arguments) {
				if (notFirst) {
					append(", ")
				}
				else {
					notFirst = true
				}
				appendDoc(argument.type)
			}
			append(">")
			if (nullable) {
				append(")?")
			}
		}
		return this
	}

	companion object {
		private val descriptorRenderer = DescriptorRenderer.withOptions {
			classifierNamePolicy = ClassifierNamePolicy.SHORT
			parameterNameRenderingPolicy = ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED
			renderUnabbreviatedType = false
		}
	}
}
