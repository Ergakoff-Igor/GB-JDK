package ru.gb.ergakov.Lesson2.seminar2;

import java.util.ArrayList;

public class Homework2 {
    private final ArrayList<Developer> developers = new ArrayList<>();
    public void homework2() {

        developers.add(new FrontEnder());
        developers.add(new BackEnder());
        developers.add(new FullStack());
        developers.add(new FrontEnder());

        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i) instanceof FrontEnder) {
                (developers.get(i)).developGUI();
            }
        }
    }
}
