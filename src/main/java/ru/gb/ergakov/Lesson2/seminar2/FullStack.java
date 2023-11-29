package ru.gb.ergakov.Lesson2.seminar2;

public class FullStack extends Developer implements BackendAction, FrontAction{
    @Override
    public void back() {

    }

    @Override
    public void front() {

    }

    @Override
    public void developGUI() {
        System.out.println("FullStack GUI method");
    }
}
