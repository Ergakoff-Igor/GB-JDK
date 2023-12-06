package ru.gb.ergakov.Lesson3.homework3.Task4;

import java.util.HashMap;
import java.util.Map;

public class Task4 {

    public void task4() {
        String key1 = "Key 1";
        Integer value1 = 1;
        Pair<String, Integer> pair1 = new Pair<>(key1, value1);

        Map<String, Integer> key2 = new HashMap<>();
        key2.put("Key", 2);
        Double value2 = 2.0;
        Pair<Map<String, Integer>, Double> pair2 = new Pair<>(key2, value2);

        System.out.println(pair1);
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println();

        System.out.println(pair2);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
    }
}
