/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fighters;

/**
 *
 * @author Алексей
 */
public class Wizard extends Fighter {

    private final String typeFighter = "Волшебник";

    public Wizard(String fighterName) {
        super(fighterName, 100, 30);
    }

    public Wizard(String fighterName, String squadName) {
        super(fighterName, 100, 30, squadName);
    }

    @Override
    public String toString() {
        return typeFighter + " " + super.toString();
    }

    @Override
    public String getTypeFighter() {
        return typeFighter;
    }
}
