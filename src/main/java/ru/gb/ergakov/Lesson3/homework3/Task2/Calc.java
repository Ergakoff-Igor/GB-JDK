package ru.gb.ergakov.Lesson3.homework3.Task2;

import ru.gb.ergakov.Lesson3.homework3.Exceptions.MyDivideByZeroException;

public class Calc {
    public static <A extends Number, B extends Number> double sum(A num1, B num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <A extends Number, B extends Number> double multiply(A num1, B num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <A extends Number, B extends Number> double divide(A num1, B num2) throws ArithmeticException{
        if (num2.equals(0) || num2.equals(0.0) || num2.equals(0.0f) || num2.equals(0L)) {
            throw new MyDivideByZeroException();
        } else return num1.doubleValue() / num2.doubleValue();
    }

    public static <A extends Number, B extends Number> double subtract(A num1, B num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
