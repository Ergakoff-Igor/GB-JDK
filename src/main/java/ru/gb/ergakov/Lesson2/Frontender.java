package ru.gb.ergakov.Lesson2;

public class Frontender extends Developer implements FrontAction{
    @Override
    public void front() {
        System.out.println("Sleep");
    }
}
