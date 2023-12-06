package ru.gb.ergakov.Lesson3.homework3.Exceptions;

public class MyArraysTypeException extends RuntimeException {

    public MyArraysTypeException() {
        super("Типы массивов отличаются");
    }
}
