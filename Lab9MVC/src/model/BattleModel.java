/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.fighters.Squad;

/**
 *
 * @author Алексей
 */
public interface BattleModel {

    public void newBattle();

    public void restructureSquads();

    public void exit();

    public void start();

    public void nextRound();

    public String[] getTypeWarriors();

    public String getNameForWarrior(boolean isRandom);

    public boolean checkCorrectName(String name);

    public String getTextSelectWarriorInfo(String getSelectedItem);

    public void addWarriorLeft(String typeWarrior, String name);

    public void addWarriorRight(String typeWarrior, String name);

    public String getSquadAliveWarriors(Squad squad);

    public Squad getSquadLeft();

    public Squad getSquadRight();

    public int getLivingsSquad(Squad squad);

    public void setSquadName(Squad squad, String name);

    public String getSquadName(Squad squad);

    public String getFormattedStartDate();

    public boolean isEnd(Squad squad);

    public String getTimeToStart();

    public String getArenaStory();

    public int getNumberRound();

}
