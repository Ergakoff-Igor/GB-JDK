package ru.gb.ergakov.UI;

import ru.gb.ergakov.lesson1.lecture1.Seminar1Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralMenu extends JFrame {
    private static final int WINDOW_HEIGHT = 200;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POS_X = 500;
    private static final int WINDOW_POS_Y = 200;

    private final JButton BTN_SEMINAR_1 = new JButton("Seminar 1");
    private final JButton BTN_EXIT = new JButton("Exit program");

    public void generalMenu(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("General Menu");
        setResizable(false);

        JPanel panelButton = new JPanel();
        panelButton.add(BTN_EXIT);
        add(panelButton, BorderLayout.SOUTH);

        JPanel panelTask = new JPanel(new GridLayout(2, 1));
        panelTask.add(BTN_SEMINAR_1);
        add(panelTask, BorderLayout.CENTER);

        setVisible(true);

        BTN_EXIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        BTN_SEMINAR_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Seminar1Menu().sem1Menu();
                setVisible(false);
            }
        });
    }
}
