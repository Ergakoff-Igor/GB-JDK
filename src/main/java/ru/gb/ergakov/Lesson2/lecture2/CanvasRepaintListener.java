package ru.gb.ergakov.Lesson2.lecture2;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
