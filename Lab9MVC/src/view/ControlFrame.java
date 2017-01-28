/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import controller.BattleController;
import java.awt.Point;

/**
 *
 * @author Алексей
 */
public class ControlFrame extends JFrame {

    private BattleController controller;
    private JMenuItem newBattle;
    private JMenuItem restructureSquads;
    private JMenuItem exitItem;
    JButton startBattle;
    private TextLabel nameSquadLeft;
    private TextLabel nameSquadRight;
    private TextLabel livingsSquadLeft;
    private TextLabel livingsSquadRight;
    private TextArea warriorsSquadLeft;
    private TextArea warriorsSquadRight;
    private TextArea arena;
    private JMenu jMenu;
    private JScrollPane scrollPaneArena;

    private TextLabel numberRound;
    private TextLabel timeBattle;

    public ControlFrame(BattleController controller) {
        this.controller = controller;
        initComponent();
        setDefaultValues();
        createListeners();
    }

    public void setDefaultValues() {
        setNumberRound(0);
        setTimeBattle("0 минут");
        setNameSquadLeft("Первый отряд");
        setNameSquadRight("Второй отряд");
        setLivingsSquadLeft(0);
        setLivingsSquadRight(0);
        setWarriorsSquadLeft("");
        setWarriorsSquadRight("");
        setArena("");
        startBattle.setEnabled(true);
    }

    private void initComponent() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        numberRound = new TextLabel(SwingConstants.CENTER);
        timeBattle = new TextLabel(SwingConstants.CENTER);

        nameSquadLeft = new TextLabel(SquadType.LEFT);
        nameSquadRight = new TextLabel(SquadType.RIGHT);

        livingsSquadLeft = new TextLabel(SquadType.LEFT);
        livingsSquadRight = new TextLabel(SquadType.RIGHT);

        warriorsSquadLeft = new TextArea(SquadType.LEFT);
        warriorsSquadRight = new TextArea(SquadType.RIGHT);

        arena = new TextArea();

        scrollPaneArena = new JScrollPane(arena);

        startBattle = new JButton("Бой!");
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(0, 10, 0, 10);
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 0;
        //первая колонка (левая команда):
        c.gridx = 0;
        c.gridy = 0;
        add(new TextLabel("Отряд:", SquadType.LEFT), c);

        c.gridx = 0;
        c.gridy = 1;
        add(nameSquadLeft, c);

        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(new JScrollPane(warriorsSquadLeft), c);
        c.weighty = 0;

        c.gridx = 0;
        c.gridy = 3;
        add(livingsSquadLeft, c);
        //вторая колонка (правая команда):
        c.gridx = 2;
        c.gridy = 0;
        add(new TextLabel("Отряд:", SquadType.RIGHT), c);
        c.gridx = 2;
        c.gridy = 1;
        add(nameSquadRight, c);

        c.weighty = 1;
        c.gridx = 2;
        c.gridy = 2;
        add(new JScrollPane(warriorsSquadRight), c);
        c.weighty = 0;

        c.gridx = 2;
        c.gridy = 3;
        add(livingsSquadRight, c);

        //средняя колонка 
        c.weightx = 1;

        c.gridx = 1;
        c.gridy = 0;
        add(numberRound, c);

        c.gridx = 1;
        c.gridy = 1;
        add(timeBattle, c);

        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 2;
        add(scrollPaneArena, c);
        c.weighty = 0;

        c.insets = new Insets(10, 10, 20, 10);//отступ снизу

        c.gridx = 1;
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        add(startBattle, c);

        jMenu = new JMenu("Меню");

        newBattle = new JMenuItem("Новая битва");
        jMenu.add(newBattle);

        restructureSquads = new JMenuItem("Настройки боя");
        jMenu.add(restructureSquads);

        jMenu.addSeparator();
        exitItem = new JMenuItem("Выход");
        jMenu.add(exitItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(jMenu);
        setJMenuBar(menuBar);
        pack();
        setVisible(true);
    }

    private void createListeners() {
        newBattle.addActionListener(event -> controller.newBattle());
        restructureSquads.addActionListener(event -> controller.restructureSquads());
        exitItem.addActionListener(event -> controller.exit());
        startBattle.addActionListener(event -> controller.start());

    }

    public void autoScroll() {
        scrollPaneArena.getViewport().setViewPosition(new Point(10, arena.getDocument().getLength()));
    }

    public void setEnabledButtonOnBattle(Boolean state) {
        startBattle.setEnabled(state);//отключение кнопок на время демонстрации
        jMenu.setEnabled(state);
    }

    public void setNameSquadLeft(String name) {
        nameSquadLeft.setText(name);
    }

    public String getNameSquadLeft() {
        return nameSquadLeft.getText();
    }

    public String getNameSquadRight() {
        return nameSquadRight.getText();
    }

    public void setNameSquadRight(String name) {
        nameSquadRight.setText(name);
    }

    public void setLivingsSquadLeft(int countLivingsSquadLeft) {
        livingsSquadLeft.setText("Живых:" + countLivingsSquadLeft);
    }

    public void setLivingsSquadRight(int countLivingsSquadRight) {
        livingsSquadRight.setText("Живых:" + countLivingsSquadRight);
    }

    public void setWarriorsSquadLeft(String text) {
        warriorsSquadLeft.setText(text);
    }

    public void addWarriorsSquadLeft(String text) {
        warriorsSquadLeft.setText(warriorsSquadLeft.getText() + "\n" + text);
    }

    public void setWarriorsSquadRight(String text) {
        warriorsSquadRight.setText(text);
    }

    public void addWarriorsSquadRight(String text) {
        warriorsSquadRight.setText(warriorsSquadRight.getText() + "\n" + text);
    }

    public void setArena(String text) {
        arena.setText(text);
    }

    public void addArenaText(String text) {
        arena.setText(arena.getText() + "\n" + text);
    }

    public void setNumberRound(int number) {
        numberRound.setText("Раунд №:" + number);
    }

    public void setTimeBattle(String time) {
        timeBattle.setText("Время с начала: " + time);
    }

    private class TextLabel extends JLabel {

        public TextLabel(String text, SquadType squadType, int horisontalAligment) {
            super(text, horisontalAligment);
            setForeground(squadType.getColor());
        }

        public TextLabel(String text, int horisontalAligment) {
            super(text, horisontalAligment);
        }

        public TextLabel(int horisontalAligment) {
            super("", horisontalAligment);
        }

        public TextLabel(String text, SquadType squadType) {
            super(text);
            setForeground(squadType.getColor());
        }

        public TextLabel(SquadType squadType) {
            super("");
            setForeground(squadType.getColor());
        }

        public TextLabel(String text) {
            super(text);
        }

        public boolean isEmpty() {
            return getText().length() == 0;
        }
    }

    private class TextArea extends JTextArea {

        public TextArea(SquadType squadType) {
            super(10, 30);
            setForeground(squadType.getColor());
            setEditable(false);
        }

        public TextArea() {
            super(10, 10);
            setEditable(false);
        }

        public void addText(String text) {
            setText(getText() + "\n" + text);
        }

        public boolean isEmpty() {
            return getText().length() == 0;
        }
    }

}
