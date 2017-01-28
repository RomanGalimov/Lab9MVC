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
public class FighterFactory {

    private final Fighter[] allTypeFighters = {new Archer(""), new Viking(""), new Wizard("")};

    public String[] getTypeFighters() {
        String[] typeFighters = new String[allTypeFighters.length];
        for (int i = 0; i < allTypeFighters.length; i++) {
            typeFighters[i] = allTypeFighters[i].getTypeFighter();
        }
        return typeFighters;
    }

    public Fighter createFighter(String type, String fighterName) {
        for (Fighter typeFighter : allTypeFighters) {
            if (typeFighter.getTypeFighter().equals(type)) {
                try {
                    Fighter createFighter = typeFighter.clone();
                    createFighter.setFighterName(fighterName);
                    return createFighter;
                } catch (CloneNotSupportedException ex) {
                    System.out.println(ex);
                }
            }
        }
        return null;
    }

}
