/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fighters;

public class Viking extends Fighter {

    private final String typeFighter = "Викинг";

    public Viking(String fighterName, String squadName) {
        super(fighterName, 120, 20, squadName);
    }

    public Viking(String fighterName) {
        super(fighterName, 120, 20);
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
