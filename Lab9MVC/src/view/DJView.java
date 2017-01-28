/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BattleController;
import javax.swing.JOptionPane;

/**
 *
 * @author Алексей
 */
public class DJView {

    private ControlFrame controlFrame;
    private SettingDialog settingDialog;

    public DJView(BattleController battleController, String[] typeFighters) {
        this.controlFrame = new ControlFrame(battleController);
        settingDialog = new SettingDialog(battleController, typeFighters);
    }

    public String getNameDialogSquadLeft() {
        return settingDialog.getNameSquadLeft();
    }

    public String getNameDialogSquadRight() {
        return settingDialog.getNameSquadRight();
    }

    public void showSettingDialog(String NameSquadLeft, String NameSquadRight) {
        settingDialog.showSettingDialog(NameSquadLeft, NameSquadRight);
    }

    public boolean isNewBattle() {
        Object[] options = {"Да", "Отмена"};
        int result = JOptionPane.showOptionDialog(controlFrame, "Вы действительно хотите удалить всех бойцов\nи начать новую битву?",
                "Новая битва", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        return result == 0;
    }

    public void setStateRandName(boolean enabled, String name) {
        settingDialog.setStatefighterNameField(enabled, name);
    }

    public boolean randomNameIsSelected() {
        return settingDialog.randomNameIsSelected();
    }

    public void newBattle() {
        controlFrame.setDefaultValues();
    }

    public void showErrorInputName(String textError) {
        JOptionPane.showMessageDialog(settingDialog, textError, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }

    public void setTextWarriorInfo(String text) {
        settingDialog.setTextWarriorInfo(text);
    }

    public String getFighterName() {
        return settingDialog.getFighterName();
    }

    public boolean isOtradLeft() {
        return settingDialog.isOtradLeft();
    }

    public boolean isOtradRight() {
        return settingDialog.isOtradRight();
    }

    public String getSelectedItem() {
        return settingDialog.getSelectedItem();
    }

    public void addWarriorsSquadLeft(String text) {
        controlFrame.addWarriorsSquadLeft(text);
    }

    public void addWarriorsSquadRight(String text) {
        controlFrame.addWarriorsSquadRight(text);
    }

    public void setWarriorsSquadLeft(String text) {
        controlFrame.setWarriorsSquadLeft(text);
    }

    public void setWarriorsSquadRight(String text) {
        controlFrame.setWarriorsSquadRight(text);
    }

    public void setLivingsSquadLeft(int count) {
        controlFrame.setLivingsSquadLeft(count);
    }

    public void setLivingsSquadRight(int count) {
        controlFrame.setLivingsSquadRight(count);
    }

    public void setNameSquadLeftFrame(String name) {
        controlFrame.setNameSquadLeft(name);
    }

    public void setNameSquadRightFrame(String name) {
        controlFrame.setNameSquadRight(name);
    }

    public void setEnabledButtonOnBattle(Boolean state) {
        controlFrame.setEnabledButtonOnBattle(state);
    }

    public void addArenaText(String text) {
        controlFrame.addArenaText(text);
    }

    public void arenaAutoScroll() {
        controlFrame.autoScroll();
    }

    public void setTimeBattle(String time) {
        controlFrame.setTimeBattle(time);
    }

    public void setArenaText(String text) {
        controlFrame.setArena(text);
    }

    public void setNumberRound(int number) {
        controlFrame.setNumberRound(number);
    }

    public void showWinDialog(String winSquadName) {
        JOptionPane.showMessageDialog(controlFrame, "Бой закончен! \nПобедила команда \"" + winSquadName + "\"!", "GameOver :(", JOptionPane.INFORMATION_MESSAGE);
    }
}
