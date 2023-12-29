package ru.gb.ergakov.Lesson6.Homework6;

import java.util.HashMap;
import java.util.Map;

public class Doors {
    private Map<Integer, Prizes> doors;
    private RandomEnumGenerator reg = new RandomEnumGenerator(Prizes.class);

    public Doors() {
        doors = new HashMap<>();
    }

    public void setDoor(Integer key, Prizes prize) {
        doors.put(key, prize);
    }

    public Map<Integer, Prizes> getDoors() {
        return doors;
    }

    public void addDoor() {
        if (isContainsPrize(Prizes.CAR)) {
            doors.put(doors.size() + 1, Prizes.GOAT);
        } else {
            doors.put(doors.size() + 1, (Prizes) reg.randomEnum());
        }
    }

    public boolean isContainsPrize(Prizes prize) {
       return doors.containsValue(prize);
    }

    public Prizes getPrize(Integer key) {
        return doors.get(key);
    }

}
