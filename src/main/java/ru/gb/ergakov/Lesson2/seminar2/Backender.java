package ru.gb.ergakov.Lesson2.seminar2;

public class Backender extends Developer implements BackendAction{
    @Override
    public void back() {
        System.out.println("Backend working");
    }
}
