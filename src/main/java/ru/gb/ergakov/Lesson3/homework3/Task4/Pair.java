package ru.gb.ergakov.Lesson3.homework3.Task4;

public class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
//        return String.format("First -> " + first + ": Second ->" + second);
        return String.format("First -> %s : Second -> %s", first.toString(), second.toString());
    }
}
