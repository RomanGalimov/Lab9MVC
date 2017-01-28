/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BattleController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Алексей
 */
public class SettingDialog extends JOptionPane {

    private BattleController controller;
    private JTextField leftName;
    private JTextField rightName;
    private JComboBox selectWarrior;
    private JLabel warriorInfo;
    private JCheckBox otradLeft;
    private JCheckBox otradRight;
    private JTextField fighterNameField;
    private JButton butAdd;
    private JCheckBox randomName;

    public SettingDialog(BattleController controller, String[] typeFighters) {
        this.controller = controller;
        initComponent(typeFighters);
        createListeners();
    }

    private void initComponent(String[] typeFighters) {
        leftName = new JTextField();
        rightName = new JTextField();
        selectWarrior = new JComboBox();
        warriorInfo = new JLabel();
        otradLeft = new JCheckBox();
        otradLeft.setForeground(Color.RED);
        otradRight = new JCheckBox();
        otradRight.setForeground(Color.BLUE);
        fighterNameField = new JTextField();
        butAdd = new JButton("Добавить");
        randomName = new JCheckBox("Случайное имя");
        for (String type : typeFighters) {
            selectWarrior.addItem(type);
        }
    }

    private void createListeners() {
        selectWarrior.addActionListener(ActionEvent -> controller.selectVarrior((String) selectWarrior.getSelectedItem()));//
        randomName.addActionListener(ActionEvent -> controller.randomNameListener());
        butAdd.addActionListener(ActionEvent -> controller.butAddListener());
    }

    public void showSettingDialog(String nameSquadLeft, String nameSquadRight) {
        leftName.setText(nameSquadLeft);
        rightName.setText(nameSquadRight);
        otradLeft.setText("В отряд: \"" + nameSquadLeft + "\"");
        otradRight.setText("В отряд: \"" + nameSquadRight + "\"");

        Object[] ob = {
            new JLabel("Название первого отряда:"),
            leftName,
            new JLabel("Название второго отряда:"),
            rightName,
            new JLabel("Добавить бойца:"),
            warriorInfo,
            selectWarrior,
            new JLabel("Имя бойца:"),
            fighterNameField,
            randomName,
            otradLeft,
            otradRight,
            butAdd
        };
        showMessageDialog(null, ob, "Добавление бойцов", JOptionPane.PLAIN_MESSAGE);
        controller.okSettingDialogListener();
    }

    public boolean isOtradLeft() {
        return otradLeft.isSelected();
    }

    public boolean isOtradRight() {
        return otradRight.isSelected();
    }

    public String getFighterName() {
        return fighterNameField.getText();
    }

    public String getNameSquadLeft() {
        return leftName.getText();
    }

    public String getNameSquadRight() {
        return rightName.getText();
    }

    public void setTextWarriorInfo(String text) {
        warriorInfo.setText(text);
    }

    public boolean randomNameIsSelected() {
        return randomName.isSelected();
    }

    public void setStatefighterNameField(Boolean enabled, String text) {
        fighterNameField.setEnabled(enabled);
        fighterNameField.setText(text);
    }

    public String getSelectedItem() {
        return (String) selectWarrior.getSelectedItem();
    }
}
