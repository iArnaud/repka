package edu.jetbrains.options;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.jetbrains.util.Util;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.UndoableEdit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsUIJPanel extends JPanel {

    private JPanel rootPanel;
    private JCheckBox showLiveTemplatesCB;
    private JCheckBox showLiveTemplatesOnEmptySpaceCB;
    private JCheckBox inWordAutoActivationCB;
    private JCheckBox outOfWordAutoActivation;
    private JTextField autoActivationDelayTF;
    private JPanel lowerPanel;
    private JPanel upperPanel;

    static boolean isDelayOk(String text, boolean allowEmpty) {
        if (text == null || text.length() == 0) {
            return allowEmpty;
        }
        Integer integer = Util.getInt(text);
        if (integer != null && integer.intValue() > 0) {
            return true;
        }
        return false;
    }

    public OptionsUIJPanel() {
        autoActivationDelayTF.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                try {
                    UndoableEdit edit = e.getEdit();
                    int length = autoActivationDelayTF.getDocument().getLength();
                    String text = autoActivationDelayTF.getDocument().getText(0, length);
                    if (!isDelayOk(text, true) && edit.canUndo()) {
                        edit.undo();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        showLiveTemplatesCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fixState();
            }
        });
    }

    void fixState() {
        if (!showLiveTemplatesCB.isSelected()) {
            showLiveTemplatesOnEmptySpaceCB.setSelected(false);
            showLiveTemplatesOnEmptySpaceCB.setEnabled(false);
        } else {
            showLiveTemplatesOnEmptySpaceCB.setEnabled(true);
        }
    }

    public void setData(OptionsBean data) {
        showLiveTemplatesCB.setSelected(data.isShowLiveTemplates());
        showLiveTemplatesOnEmptySpaceCB.setSelected(data.isShowLiveTemplatesOnEmptySpace());
        outOfWordAutoActivation.setSelected(data.isOutOfWordAutoActivation());
        String text = data.getAutoActivationDelay();
        if (!isDelayOk(text, false)) {
            text = BeanManager.defaultBean().getAutoActivationDelay();
        }
        autoActivationDelayTF.setText(text);
        inWordAutoActivationCB.setSelected(data.isInWordAutoActivation());
        fixState();
    }

    public void getData(OptionsBean data) {
        data.setShowLiveTemplates(showLiveTemplatesCB.isSelected());
        data.setShowLiveTemplatesOnEmptySpace(showLiveTemplatesOnEmptySpaceCB.isSelected());
        data.setOutOfWordAutoActivation(outOfWordAutoActivation.isSelected());
        String text = autoActivationDelayTF.getText();
        if (!isDelayOk(text, false)) {
            text = BeanManager.defaultBean().getAutoActivationDelay();
        }
        data.setAutoActivationDelay(text);
        data.setInWordAutoActivation(inWordAutoActivationCB.isSelected());
    }

    public boolean isModified(OptionsBean data) {
        if (showLiveTemplatesCB.isSelected() != data.isShowLiveTemplates()) return true;
        if (showLiveTemplatesOnEmptySpaceCB.isSelected() != data.isShowLiveTemplatesOnEmptySpace()) return true;
        if (outOfWordAutoActivation.isSelected() != data.isOutOfWordAutoActivation()) return true;
        if (autoActivationDelayTF.getText() != null ? !autoActivationDelayTF.getText().equals(data.getAutoActivationDelay()) : data.getAutoActivationDelay() != null)
            return true;
        if (inWordAutoActivationCB.isSelected() != data.isInWordAutoActivation()) return true;
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
        showLiveTemplatesCB.setMargin(new Insets(5, 5, 5, 5));
        showLiveTemplatesCB.setSelected(true);
        showLiveTemplatesCB.setText("Show live templates in auto-complete list");
        lowerPanel.add(showLiveTemplatesCB, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showLiveTemplatesOnEmptySpaceCB = new JCheckBox();
        showLiveTemplatesOnEmptySpaceCB.setActionCommand("Show live templates in out-of-word completion");
        showLiveTemplatesOnEmptySpaceCB.setMargin(new Insets(5, 5, 5, 5));
        showLiveTemplatesOnEmptySpaceCB.setText("Show live templates on empty space");
        showLiveTemplatesOnEmptySpaceCB.putClientProperty("html.disable", Boolean.TRUE);
        lowerPanel.add(showLiveTemplatesOnEmptySpaceCB, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(upperPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        upperPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Extended Auto Activation"));
        outOfWordAutoActivation = new JCheckBox();
        outOfWordAutoActivation.setMargin(new Insets(5, 5, 5, 5));
        outOfWordAutoActivation.setSelected(false);
        outOfWordAutoActivation.setText("Enable out-of-word completion auto activation");
        upperPanel.add(outOfWordAutoActivation, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Auto activation delay, ms:");
        upperPanel.add(label1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        inWordAutoActivationCB = new JCheckBox();
        inWordAutoActivationCB.setMargin(new Insets(5, 5, 5, 5));
        inWordAutoActivationCB.setSelected(true);
        inWordAutoActivationCB.setText("Enable in-word completion auto activation");
        upperPanel.add(inWordAutoActivationCB, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        autoActivationDelayTF = new JTextField();
        autoActivationDelayTF.setInheritsPopupMenu(false);
        autoActivationDelayTF.setMargin(new Insets(5, 5, 5, 5));
        autoActivationDelayTF.setText("200");
        upperPanel.add(autoActivationDelayTF, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
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