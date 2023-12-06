package ru.gb.ergakov.Lesson3.homework3.Task2;

public class ProgramCalc {

    public void programCalc() {
        int num1 = 5;
        float num2 = 10;
        System.out.println(num1 + " + " + num2 + " = " + Calc.sum(num1, num2));
        System.out.println(num1 + " - " + num2 + " = " + Calc.subtract(num1, num2));
        System.out.println(num1 + " * " + num2 + " = " + Calc.multiply(num1, num2));
        System.out.println(num1 + " / " + num2 + " = " + Calc.divide(num1, num2));
    }
}
