package ru.gb.ergakov.Lesson3.Seminar3;

import java.io.DataInput;
import java.io.InputStream;

public class MegaClass<T extends Comparable, V extends InputStream & DataInput, K extends Number> {
    public T t;
    public V v;
    public K k;

    public MegaClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printTypes() {
        System.out.println(t.getClass().getSimpleName() + " " +
                v.getClass().getSimpleName() + " " +
                k.getClass().getSimpleName());
    }
}
