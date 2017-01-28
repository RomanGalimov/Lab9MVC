/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9mvc;

import controller.BattleControllerImpl;
import javax.swing.UIManager;
import model.BattleModelImpl;

/**
 *
 * @author Алексей
 */
public class Lab9MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        new BattleControllerImpl(new BattleModelImpl());
    }
}
