/*
 * Created by JFormDesigner on Tue Aug 23 14:04:31 CST 2022
 */

package com.github.bin.bugktdoc.ui;

import com.intellij.ui.TitledSeparator;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author bin
 */
public class BugKtDocConfigureForm {

	protected BugKtDocConfigureForm() {
		initComponents();
	}

	@SuppressWarnings({"UseDPIAwareInsets", "AlibabaMethodTooLong"})
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		panel = new JPanel();
		useDoc = new JBCheckBox();
		separator1 = new TitledSeparator();
		useFunctionDoc = new JBCheckBox();
		funGeneric = new JBCheckBox();
		funContext = new JBCheckBox();
		funReceiver = new JBCheckBox();
		funReturn = new JBCheckBox();
		alwaysShowUnitReturnType = new JBCheckBox();
		funThrows = new JBCheckBox();
		separator3 = new JSeparator();
		useClassDoc = new JBCheckBox();
		classGeneric = new JBCheckBox();
		classParam = new JBCheckBox();
		classProperty = new JBCheckBox();
		classConstructor = new JBCheckBox();
		separator4 = new JSeparator();
		useConstructorDoc = new JBCheckBox();
		constructorParam = new JBCheckBox();
		constructorConstructor = new JBCheckBox();
		separator2 = new TitledSeparator();
		showBuiltinType = new JBCheckBox();
		var vSpacer1 = new Spacer();

		//======== panel ========
		{
			panel.setLayout(new GridLayoutManager(23, 1, new Insets(0, 0, 0, 0), 4, -1));
			panel.add(useDoc, new GridConstraints(0, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null));
			panel.add(separator1, new GridConstraints(1, 0, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null));
			panel.add(useFunctionDoc, new GridConstraints(2, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 2));
			panel.add(funGeneric, new GridConstraints(3, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(funContext, new GridConstraints(4, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(funReceiver, new GridConstraints(5, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(funReturn, new GridConstraints(6, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(alwaysShowUnitReturnType, new GridConstraints(7, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 6));
			panel.add(funThrows, new GridConstraints(8, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));

			//---- separator3 ----
			separator3.setName("aaaaaa");
			panel.add(separator3, new GridConstraints(9, 0, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 2));
			panel.add(useClassDoc, new GridConstraints(10, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 2));
			panel.add(classGeneric, new GridConstraints(11, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(classParam, new GridConstraints(12, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(classProperty, new GridConstraints(13, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(classConstructor, new GridConstraints(14, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(separator4, new GridConstraints(15, 0, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 2));
			panel.add(useConstructorDoc, new GridConstraints(16, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 2));
			panel.add(constructorParam, new GridConstraints(17, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(constructorConstructor, new GridConstraints(18, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 4));
			panel.add(separator2, new GridConstraints(19, 0, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null));
			panel.add(showBuiltinType, new GridConstraints(20, 0, 1, 1,
				GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, null, null, 2));
			panel.add(vSpacer1, new GridConstraints(21, 0, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
				GridConstraints.SIZEPOLICY_CAN_SHRINK,
				GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
				null, null, null));
		}

		initComponentsI18n();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	@SuppressWarnings({"AlibabaMethodTooLong"})
	private void initComponentsI18n() {
		// JFormDesigner - Component i18n initialization - DO NOT MODIFY  //GEN-BEGIN:initI18n
		ResourceBundle bundle = ResourceBundle.getBundle("BugKtDocBundle");
		useDoc.setText(bundle.getString("bugktdoc.options.use"));
		useDoc.setToolTipText(bundle.getString("bugktdoc.options.use.toolTip"));
		separator1.setText(bundle.getString("bugktdoc.options.separator"));
		useFunctionDoc.setText(bundle.getString("bugktdoc.options.use.functionDoc"));
		useFunctionDoc.setToolTipText(bundle.getString("bugktdoc.options.use.functionDoc.toolTip"));
		funGeneric.setText(bundle.getString("bugktdoc.options.use.functionDoc.@param"));
		funGeneric.setToolTipText(bundle.getString("bugktdoc.options.use.functionDoc.@param.toolTip"));
		funContext.setText(bundle.getString("bugktdoc.options.use.functionDoc.@context"));
		funContext.setToolTipText(bundle.getString("bugktdoc.options.use.functionDoc.@context.toolTip"));
		funReceiver.setText(bundle.getString("bugktdoc.options.use.functionDoc.@receiver"));
		funReceiver.setToolTipText(bundle.getString("bugktdoc.options.use.functionDoc.@receiver.toolTip"));
		funReturn.setText(bundle.getString("bugktdoc.options.use.functionDoc.@return"));
		funReturn.setToolTipText(bundle.getString("bugktdoc.options.use.functionDoc.@return.toolTip"));
		alwaysShowUnitReturnType.setText(bundle.getString("bugktdoc.options.use.functionDoc.returnUnit"));
		alwaysShowUnitReturnType.setToolTipText(bundle.getString("bugktdoc.options.use.functionDoc.returnUnit.toolTip"));
		funThrows.setText(bundle.getString("bugktdoc.options.use.functionDoc.@throws"));
		funThrows.setToolTipText(bundle.getString("bugktdoc.options.use.functionDoc.@throws.toolTip"));
		useClassDoc.setText(bundle.getString("bugktdoc.options.use.classDoc"));
		useClassDoc.setToolTipText(bundle.getString("bugktdoc.options.use.classDoc.toolTip"));
		classGeneric.setText(bundle.getString("bugktdoc.options.use.classDoc.generic@param"));
		classGeneric.setToolTipText(bundle.getString("bugktdoc.options.use.classDoc.generic@param.toolTip"));
		classParam.setText(bundle.getString("bugktdoc.options.use.classDoc.@param"));
		classParam.setToolTipText(bundle.getString("bugktdoc.options.use.classDoc.@param.toolTip"));
		classProperty.setText(bundle.getString("bugktdoc.options.use.classDoc.@property"));
		classProperty.setToolTipText(bundle.getString("bugktdoc.options.use.classDoc.@property.toolTip"));
		classConstructor.setText(bundle.getString("bugktdoc.options.use.classDoc.@constructor"));
		classConstructor.setToolTipText(bundle.getString("bugktdoc.options.use.classDoc.@constructor.toolTip"));
		useConstructorDoc.setText(bundle.getString("bugktdoc.options.use.constructorDoc"));
		useConstructorDoc.setToolTipText(bundle.getString("bugktdoc.options.use.constructorDoc.toolTip"));
		constructorParam.setText(bundle.getString("bugktdoc.options.use.constructorDoc.@param"));
		constructorParam.setToolTipText(bundle.getString("bugktdoc.options.use.constructorDoc.@param.toolTip"));
		constructorConstructor.setText(bundle.getString("bugktdoc.options.use.constructorDoc.@constructor"));
		constructorConstructor.setToolTipText(bundle.getString("bugktdoc.options.use.constructorDoc.@constructor.toolTip"));
		separator2.setText(bundle.getString("bugktdoc.options.separator.other"));
		showBuiltinType.setText(bundle.getString("bugktdoc.options.showBuiltinType"));
		showBuiltinType.setToolTipText(bundle.getString("bugktdoc.options.showBuiltinType.toolTip"));
		// JFormDesigner - End of component i18n initialization  //GEN-END:initI18n
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	protected JPanel panel;
	protected JBCheckBox useDoc;
	protected TitledSeparator separator1;
	protected JBCheckBox useFunctionDoc;
	protected JBCheckBox funGeneric;
	protected JBCheckBox funContext;
	protected JBCheckBox funReceiver;
	protected JBCheckBox funReturn;
	protected JBCheckBox alwaysShowUnitReturnType;
	protected JBCheckBox funThrows;
	protected JSeparator separator3;
	protected JBCheckBox useClassDoc;
	protected JBCheckBox classGeneric;
	protected JBCheckBox classParam;
	protected JBCheckBox classProperty;
	protected JBCheckBox classConstructor;
	protected JSeparator separator4;
	protected JBCheckBox useConstructorDoc;
	protected JBCheckBox constructorParam;
	protected JBCheckBox constructorConstructor;
	protected TitledSeparator separator2;
	protected JBCheckBox showBuiltinType;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
