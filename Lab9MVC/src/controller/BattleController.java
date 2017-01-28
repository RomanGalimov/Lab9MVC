/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Алексей
 */
public interface BattleController {

    public void newBattle();

    public void restructureSquads();

    public void exit();

    public void start();

    public void selectVarrior(String selectedItem);

    public void randomNameListener();

    public void butAddListener();

    public void okSettingDialogListener();

}
