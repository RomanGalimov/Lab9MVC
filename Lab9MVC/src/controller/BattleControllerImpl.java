/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.BattleModel;
import view.DJView;

/**
 *
 * @author Алексей
 */
public class BattleControllerImpl implements BattleController {

    private BattleModel model;
    private DJView view;

    public BattleControllerImpl(BattleModel model) {
        this.model = model;
        view = new DJView(this, model.getTypeWarriors());
    }

    @Override
    public void newBattle() {
        if (view.isNewBattle()) {
            view.newBattle();
            model.newBattle();
        }
    }

    @Override
    public void restructureSquads() {
        view.setTextWarriorInfo(model.getTextSelectWarriorInfo(model.getTypeWarriors()[0]));
        view.showSettingDialog(model.getSquadName(model.getSquadLeft()), model.getSquadName(model.getSquadRight()));
    }

    @Override
    public void okSettingDialogListener() {
        if (model.checkCorrectName(view.getNameDialogSquadLeft())) {
            model.setSquadName(model.getSquadLeft(), view.getNameDialogSquadLeft());
            view.setNameSquadLeftFrame(view.getNameDialogSquadLeft());
        } else {
            view.showErrorInputName("Имя первой команды введено неверно");
        }
        if (model.checkCorrectName(view.getNameDialogSquadRight())) {
            if (view.getNameDialogSquadRight().equals(view.getNameDialogSquadLeft())) {
                view.showErrorInputName("Одинаковые имена недопустимы!");
            } else {
                model.setSquadName(model.getSquadRight(), view.getNameDialogSquadRight());
                view.setNameSquadRightFrame(view.getNameDialogSquadRight());
            }
        } else {
            view.showErrorInputName("Имя второй команды введено неверно");
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void start() {
        if (model.getLivingsSquad(model.getSquadLeft()) == 0) {
            view.showErrorInputName("В отряде: \"" + model.getSquadName(model.getSquadLeft()) + "\" отсутствуют бойцы!");
            return;
        }
        if (model.getLivingsSquad(model.getSquadRight()) == 0) {
            view.showErrorInputName("В отряде: \"" + model.getSquadName(model.getSquadRight()) + "\" отсутствуют бойцы!");
            return;
        }
        view.setEnabledButtonOnBattle(false);
        new Thread(() -> {

            model.start();
            view.setArenaText(model.getArenaStory());

            while (!model.isEnd(model.getSquadLeft()) && !model.isEnd(model.getSquadRight())) {
                view.setNumberRound(model.getNumberRound());
                model.nextRound();
                view.setWarriorsSquadLeft(model.getSquadAliveWarriors(model.getSquadLeft()));
                view.setWarriorsSquadRight(model.getSquadAliveWarriors(model.getSquadRight()));
                view.setLivingsSquadLeft(model.getLivingsSquad(model.getSquadLeft()));
                view.setLivingsSquadRight(model.getLivingsSquad(model.getSquadRight()));
                view.setArenaText(model.getArenaStory());
                view.setTimeBattle(model.getTimeToStart());
                view.arenaAutoScroll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }

            if (!model.isEnd(model.getSquadLeft())) {
                view.addArenaText("\nПобедил отряд \"" + model.getSquadLeft() + "\"!");
                view.showWinDialog(model.getSquadName(model.getSquadLeft()));
            } else {
                view.addArenaText("\nПобедил отряд \"" + model.getSquadRight() + "\"!");
                view.showWinDialog(model.getSquadName(model.getSquadRight()));
            }
            view.setEnabledButtonOnBattle(true);
        }
        ).start();
    }

    @Override
    public void selectVarrior(String selectedItem) {
        view.setTextWarriorInfo(model.getTextSelectWarriorInfo(selectedItem));
    }

    @Override
    public void randomNameListener() {
        view.setStateRandName(!view.randomNameIsSelected(), model.getNameForWarrior(view.randomNameIsSelected()));
    }

    @Override
    public void butAddListener() {
        if (!model.checkCorrectName(view.getFighterName())) {
            view.showErrorInputName("Имя бойца введено неверно");
            return;
        }
        if (view.isOtradLeft()) {
            model.addWarriorLeft(view.getSelectedItem(), view.getFighterName());
        }
        if (view.isOtradRight()) {
            model.addWarriorRight(view.getSelectedItem(), view.getFighterName());
        }
        view.setStateRandName(!view.randomNameIsSelected(), model.getNameForWarrior(view.randomNameIsSelected()));
        view.setWarriorsSquadLeft(model.getSquadAliveWarriors(model.getSquadLeft()));
        view.setWarriorsSquadRight(model.getSquadAliveWarriors(model.getSquadRight()));
        view.setLivingsSquadLeft(model.getLivingsSquad(model.getSquadLeft()));
        view.setLivingsSquadRight(model.getLivingsSquad(model.getSquadRight()));
    }

}
