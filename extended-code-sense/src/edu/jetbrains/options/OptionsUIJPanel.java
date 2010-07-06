package edu.jetbrains.options;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: ivan
 * Date: 06.07.2010
 * Time: 2:28:29
 * To change this template use File | Settings | File Templates.
 */
public class OptionsUIJPanel extends JPanel {

    private JPanel rootPanel;
    private JCheckBox showLiveTemplatesCB;
    private JCheckBox showLiveTemplatesOnEmptySpaceCB;
    private JCheckBox enableExtAutoActivationCB;
    private JCheckBox enableAutoActivationInExpressionsCB;
    private JTextField autoActivationDelayTF;
    private JPanel lowerPanel;
    private JPanel upperPanel;

    public OptionsUIJPanel() {
//        enableAutoActivationInExpressionsCB.addActionListener(new ActionListener() {
//
//        });
        showLiveTemplatesCB.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            }
        });
        showLiveTemplatesOnEmptySpaceCB.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            }
        });
        enableAutoActivationInExpressionsCB.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            }
        });
        //autoActivationDelayTF.
        enableExtAutoActivationCB.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            }
        });
    }

    public void setData(OptionsBean data) {
        showLiveTemplatesCB.setSelected(data.isShowLiveTemplates());
        showLiveTemplatesOnEmptySpaceCB.setSelected(data.isShowLiveTemplatesOnEmptySpace());
        enableAutoActivationInExpressionsCB.setSelected(data.isEnableAutoActivationInExpressions());
        autoActivationDelayTF.setText(data.getAutoActivationDelay());
        enableExtAutoActivationCB.setSelected(data.isEnableAutoActivation());
    }

    public void getData(OptionsBean data) {
        data.setShowLiveTemplates(showLiveTemplatesCB.isSelected());
        data.setShowLiveTemplatesOnEmptySpace(showLiveTemplatesOnEmptySpaceCB.isSelected());
        data.setEnableAutoActivationInExpressions(enableAutoActivationInExpressionsCB.isSelected());
        data.setAutoActivationDelay(autoActivationDelayTF.getText());
        data.setEnableAutoActivation(enableExtAutoActivationCB.isSelected());
    }

    public boolean isModified(OptionsBean data) {
        if (showLiveTemplatesCB.isSelected() != data.isShowLiveTemplates()) return true;
        if (showLiveTemplatesOnEmptySpaceCB.isSelected() != data.isShowLiveTemplatesOnEmptySpace()) return true;
        if (enableAutoActivationInExpressionsCB.isSelected() != data.isEnableAutoActivationInExpressions()) return true;
        if (autoActivationDelayTF.getText() != null ? !autoActivationDelayTF.getText().equals(data.getAutoActivationDelay()) : data.getAutoActivationDelay() != null)
            return true;
        if (enableExtAutoActivationCB.isSelected() != data.isEnableAutoActivation()) return true;
        return false;
    }

    /**
     * @noinspection ALL
     */
    public JComponent getRootComponent() {
        return rootPanel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(lowerPanel, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lowerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Live Templates"));
        showLiveTemplatesCB = new JCheckBox();
        showLiveTemplatesCB.setSelected(true);
        showLiveTemplatesCB.setText("Show live templates in auto-complete list");
        lowerPanel.add(showLiveTemplatesCB, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showLiveTemplatesOnEmptySpaceCB = new JCheckBox();
        showLiveTemplatesOnEmptySpaceCB.setText("Show live templates on empty space");
        lowerPanel.add(showLiveTemplatesOnEmptySpaceCB, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(upperPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        upperPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Extended Auto Activation"));
        enableAutoActivationInExpressionsCB = new JCheckBox();
        enableAutoActivationInExpressionsCB.setSelected(true);
        enableAutoActivationInExpressionsCB.setText("Enable auto activation in expressions");
        upperPanel.add(enableAutoActivationInExpressionsCB, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Auto activation delay, ms:");
        upperPanel.add(label1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        autoActivationDelayTF = new JTextField();
        autoActivationDelayTF.setText("200");
        upperPanel.add(autoActivationDelayTF, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        enableExtAutoActivationCB = new JCheckBox();
        enableExtAutoActivationCB.setSelected(true);
        enableExtAutoActivationCB.setText("Enable extended auto activation");
        upperPanel.add(enableExtAutoActivationCB, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        rootPanel.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
