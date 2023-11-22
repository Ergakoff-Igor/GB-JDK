package ru.gb.ergakov.lesson1.lecture1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 200;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");
    Map map;
    SettingsWindow settings;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTakToe");
        setResizable(false);

        map = new Map();
        settings = new SettingsWindow(this);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Seminar1Menu().sem1Menu();
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(panelBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
