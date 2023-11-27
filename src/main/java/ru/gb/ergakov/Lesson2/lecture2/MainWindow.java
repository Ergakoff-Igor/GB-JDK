package ru.gb.ergakov.Lesson2.lecture2;

import ru.gb.ergakov.UI.GeneralMenu;
import ru.gb.ergakov.lesson1.lecture1.Seminar1Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Sprite[] sprites = new Sprite[10];
    private final JButton BTN_EXIT = new JButton("Exit to general menu");
    private final JButton BTN_EXIT_PROGRAM = new JButton("Exit program");

    public MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        JPanel panelExit = new JPanel(new GridLayout(1, 2));
        panelExit.add(BTN_EXIT);
        panelExit.add(BTN_EXIT_PROGRAM);
        add(panelExit, BorderLayout.SOUTH);
        setVisible(true);

        BTN_EXIT.addActionListener(e -> {
            setVisible(false);
            new GeneralMenu().generalMenu();
        });

        BTN_EXIT_PROGRAM.addActionListener(e -> System.exit(0));
    }


    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
