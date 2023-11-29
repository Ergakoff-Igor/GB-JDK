package ru.gb.ergakov.Lesson2.lecture2;

import ru.gb.ergakov.UI.GeneralMenu;


import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener{
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Interactable[] interactables = new Interactable[10];
    private final JButton BTN_EXIT = new JButton("Exit to general menu");
    private final JButton BTN_EXIT_PROGRAM = new JButton("Exit program");

    public MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        interactables[0] = new Background();
        for (int i = 0; i < interactables.length; i++) {
            interactables[i] = new Ball();
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


    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }
}
