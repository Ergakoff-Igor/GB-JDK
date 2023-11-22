package ru.gb.ergakov.lesson1.lecture1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 30;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Gamer WIN !";
    private static final String MSG_WIN_AI = "AI WON !";
    private static final String MSG_DRAW = "DRAW !";

    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;

    private boolean isGameOver;
    private boolean isInitialized;

    private int fieldSyzeY;
    private int fieldSyzeX;
    private int winLen;
    private char[][] field;

    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;

    Map() {
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    private void initMap() {
        field = new char[fieldSyzeY][fieldSyzeX];
        for (int i = 0; i < fieldSyzeY; i++) {
            for (int j = 0; j < fieldSyzeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x = %d, y = %d;\nWin Length: %d",
                mode, fSzX, fSzY, wLen);
        fieldSyzeX = fSzX;
        fieldSyzeY = fSzY;
        winLen = wLen;
        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight / fieldSyzeY;
        cellWidth = panelWidth / fieldSyzeX;

        g.setColor(Color.WHITE);
        for (int h = 0; h < fieldSyzeY; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < fieldSyzeX; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int y = 0; y < fieldSyzeY; y++) {
            for (int x = 0; x < fieldSyzeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(new Color(0x993366));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(new Color(0x9aceeb));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);

                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] +
                            " in cell: x = " + x + " y = " + y);
                }
            }
        }
        if (isGameOver) shoWMassageGameOver(g);
    }

    private void shoWMassageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW -> g.drawString(MSG_DRAW, 180, getHeight() / 2);
            case STATE_WIN_AI -> g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
            case STATE_WIN_HUMAN -> g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
            default -> throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }


    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSyzeX && y >= 0 && y < fieldSyzeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSyzeX);
            y = RANDOM.nextInt(fieldSyzeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean isMapFool() {
        for (int i = 0; i < fieldSyzeY; i++) {
            for (int j = 0; j < fieldSyzeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin((char) dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFool()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    private boolean checkWin(char c) {
        for (int i = 0; i < fieldSyzeX; i++) {
            for (int j = 0; j < fieldSyzeY; j++) {
                if (checkLine(i, j, 1, 0, winLen, c)) return true;
                if (checkLine(i, j, 1, 1, winLen, c)) return true;
                if (checkLine(i, j, 0, 1, winLen, c)) return true;
                if (checkLine(i, j, 1, -1, winLen, c)) return true;
            }
        }


//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
//
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
//
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        return field[0][2] == c && field[1][1] == c && field[2][0] == c;
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, int c) {
        final int far_x = x + (len - 1) * vx;
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;
        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != c) return false;
        }
        return true;
    }
}
