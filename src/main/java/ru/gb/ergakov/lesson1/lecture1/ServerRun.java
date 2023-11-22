package ru.gb.ergakov.lesson1.lecture1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Создать простейшее окно управления сервером (по сути, любым), содержащее две кнопки
(JButton) – запустить сервер и остановить сервер. Кнопки должны просто логировать нажатие
(имитировать запуск и остановку сервера, соответственно) и выставлять внутри интерфейса
соответствующее булево isServerWorking.
 */
public class ServerRun extends JFrame{
    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");
    JButton btnExit = new JButton("Exit");
    boolean isServerWorking;
    ServerRun(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ServerRun");
        setResizable(false);

        JPanel panelServer = new JPanel(new GridLayout(1, 2));
        panelServer.add(btnStart);
        panelServer.add(btnStop);
        add(panelServer, BorderLayout.CENTER);

        JPanel panelExit = new JPanel();
        panelExit.add(btnExit);
        add(panelExit, BorderLayout.SOUTH);

        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    isServerWorking = true;
                }
                System.out.println("Статус сервера: " + isServerWorking);
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    isServerWorking = false;
                }
                System.out.println("Статус сервера: " + isServerWorking);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Seminar1Menu().sem1Menu();
            }
        });
    }

}
