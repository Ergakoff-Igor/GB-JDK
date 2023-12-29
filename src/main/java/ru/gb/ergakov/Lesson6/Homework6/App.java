package ru.gb.ergakov.Lesson6.Homework6;


import lombok.experimental.ExtensionMethod;

import java.math.BigDecimal;

@ExtensionMethod(FastBigDecimalPercentage.class)
public class App {

    public void buttonClick() {
        int countWin = 0;
        int countLose = 0;
        int countWinChange = 0;
        int countWinFixed = 0;

        for (int i = 0; i < 1000; i++) {
            boolean chanGeChoice = i % 2 == 0;
            System.out.println(chanGeChoice);
            boolean resultGame = new Game().game(chanGeChoice);
            if(resultGame && chanGeChoice) {
                countWin++;
                countWinChange++;
            } else if(!chanGeChoice && resultGame) {
                countWin++;
                countWinFixed++;
            } else countLose++;
        }

        BigDecimal obtainedChange = new BigDecimal(countWinChange);
        BigDecimal obtainedFixed = new BigDecimal(countWinFixed);
        BigDecimal total = new BigDecimal(countWin);

        System.out.println("CountWin: " + countWin);
        System.out.println("CountLose: " + countLose);
        System.out.println("CountWinChange: " + countWinChange);
        System.out.println("CountWinFixed: " + countWinFixed);
        System.out.println("Percentage obtained WinChange:"+ obtainedChange.toPercentageOf(total));
        System.out.println("Percentage obtained WinFixed:"+ obtainedFixed.toPercentageOf(total));
    }
}
