/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.dateHelper.DateHelper;
import model.fighters.Fighter;
import model.fighters.FighterFactory;
import model.fighters.Warrior;
import model.fighters.Squad;
import model.fighters.Name;
import java.util.Random;

/**
 *
 * @author Алексей
 */
public class BattleModelImpl implements BattleModel {

    private Squad squadLeft;//левая команда (красная)
    private Squad squadRight;//правая команда (синяя)
    private final FighterFactory fighterFactory;
    private DateHelper dateHelper;
    private final int TIME_LENGTH_ROUND = 45;
    private Fighter fighterMain;// боец, который будет бить
    private Fighter fighterVictim;//боец жертва
    private boolean ferstRedTeams;//кто бьет первым
    private Random r;
    private int numberRound;
    StringBuilder arenaStory;

    public BattleModelImpl() {
        this.fighterFactory = new FighterFactory();
        newBattle();
    }

    @Override
    public Squad getSquadLeft() {
        return squadLeft;
    }

    @Override
    public void setSquadName(Squad squad, String name) {
        squad.setSquadName(name);
    }

    @Override
    public String getSquadName(Squad squad) {
        return squad.getSquadName();
    }

    @Override
    public Squad getSquadRight() {
        return squadRight;
    }

    @Override
    public void newBattle() {
        squadLeft = new Squad("Первый отряд");
        squadRight = new Squad("Второй отряд");
    }

    @Override
    public void restructureSquads() {

    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public int getNumberRound() {
        return numberRound;
    }

    @Override
    public void nextRound() {
        arenaStory.append("\nРаунд №" + numberRound + "\n");
        ferstRedTeams = r.nextBoolean();
        //определение того, кто первым бьет
        for (int j = 0; j < 2 && squadLeft.hasAliveWarriors() && squadRight.hasAliveWarriors(); j++) {
            //бьет одна команда, затем, другая
            if (ferstRedTeams) {
                fighterMain = (Fighter) squadLeft.getRandomWarrior();
                fighterVictim = (Fighter) squadRight.getRandomWarrior();
                ferstRedTeams = false;
            } else {
                fighterMain = (Fighter) squadRight.getRandomWarrior();
                fighterVictim = (Fighter) squadLeft.getRandomWarrior();
                ferstRedTeams = true;
            }
            arenaStory.append("  Бьет:" + "\n");
            arenaStory.append("  Команда:\"" + fighterMain.getSquadName() + "\" " + fighterMain + "\n");
            arenaStory.append(" VS:" + "\n");
            arenaStory.append("  " + fighterMain.getSquadName() + " " + fighterVictim + "\n");

            fighterVictim.takeDamage(fighterMain.attack());
            dateHelper.skipTime();
            if (!fighterVictim.isAlive()) {
                arenaStory.append("УБИТ:" + fighterVictim.getFighterName() + " команда:" + fighterVictim.getSquadName() + "\n");
            }
            arenaStory.append("\n");
        }
        ++numberRound;
    }

    @Override
    public String getArenaStory() {
        return arenaStory.toString();
    }

    @Override
    public String getTimeToStart() {
        return dateHelper.getFormattedDiff();
    }

    @Override
    public boolean isEnd(Squad squad) {
        return !squad.hasAliveWarriors();
    }

    @Override
    public void start() {
        r = new Random();
        numberRound = 1;
        dateHelper = new DateHelper(TIME_LENGTH_ROUND);// параметр - время в минутах одного раунда
        arenaStory = new StringBuilder("Начало поединка:" + getFormattedStartDate() + "\n");

    }

    @Override
    public String[] getTypeWarriors() {
        return fighterFactory.getTypeFighters();
    }

    @Override
    public String getNameForWarrior(boolean isRandom) {
        return isRandom ? Name.getRandName() : "";
    }

    @Override
    public boolean checkCorrectName(String name) {
        return name.length() > 0 && name.length() < 40;
    }

    @Override
    public String getTextSelectWarriorInfo(String getSelectedItem) {
        return fighterFactory.createFighter(getSelectedItem, "").toString();
    }

    @Override
    public void addWarriorLeft(String typeWarrior, String name) {
        squadLeft.addWarrior(fighterFactory.createFighter(typeWarrior, name));
    }

    @Override
    public void addWarriorRight(String typeWarrior, String name) {
        squadRight.addWarrior(fighterFactory.createFighter(typeWarrior, name));
    }

    @Override
    public String getSquadAliveWarriors(Squad squad) {
        StringBuilder stringBuilder = new StringBuilder();
        squad.getWarriors().forEach((Warrior warrior)
                -> stringBuilder.append(warrior).append(!warrior.isAlive() ? " - УБИТ" : "").append("\n"));
        return stringBuilder.toString();
    }

    @Override
    public int getLivingsSquad(Squad squad) {
        return squad.getAliveCountWarriors();
    }

    @Override
    public String getFormattedStartDate() {
        return dateHelper.getFormattedStartDate();
    }

}
