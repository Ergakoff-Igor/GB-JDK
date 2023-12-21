package ru.gb.ergakov.Lesson5.Homework5;

public class HW5 extends Thread{
    public void run() {

        Philosopher philosopher1 = new Philosopher("Philosopher-1");
        Philosopher philosopher2 = new Philosopher("Philosopher-2");
        Philosopher philosopher3 = new Philosopher("Philosopher-3");
        Philosopher philosopher4 = new Philosopher("Philosopher-4");
        Philosopher philosopher5 = new Philosopher("Philosopher-5");

        try {
            philosopher1.join();
            philosopher2.join();
            philosopher3.join();
            philosopher4.join();
            philosopher5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все философы поели и подумали");
    }

}
