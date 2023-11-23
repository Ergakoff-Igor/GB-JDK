package ru.gb.ergakov.lesson1.lecture1;

import ru.gb.ergakov.lesson1.lecture1.Chat.Chat;
import ru.gb.ergakov.lesson1.lecture1.ServerRun.ServerRun;
import ru.gb.ergakov.lesson1.lecture1.TicTacToe.GameWindow;
import ru.gb.ergakov.UI.GeneralMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Seminar1Menu extends JFrame {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POS_X = 500;
    private static final int WINDOW_POS_Y = 200;

    JButton btnTicTacToe = new JButton("Start TicTacToe");
    JButton btnChat = new JButton("Start Chat");
    JButton btnServerRun = new JButton("Start ServerRun");
    JButton btnBack = new JButton("Come back to General menu");
    JButton btnExit = new JButton("Exit program");

    public void sem1Menu (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Seminar 1. Menu");
        setResizable(false);

        JPanel panelButton = new JPanel(new GridLayout(1, 2));
        panelButton.add(btnBack);
        panelButton.add(btnExit);
        add(panelButton, BorderLayout.SOUTH);

        JPanel panelTask = new JPanel(new GridLayout(3, 1));
        panelTask.add(btnTicTacToe);
        panelTask.add(btnChat);
        panelTask.add(btnServerRun);
        add(panelTask, BorderLayout.CENTER);
        setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GeneralMenu().generalMenu();
                setVisible(false);
            }
        });

        btnTicTacToe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameWindow();
                setVisible(false);
            }
        });

        btnChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Chat();
                setVisible(false);
            }
        });

        btnServerRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServerRun();
                setVisible(false);
            }
        });

    }

}
