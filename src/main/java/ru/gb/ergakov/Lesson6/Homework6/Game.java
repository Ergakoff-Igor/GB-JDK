package ru.gb.ergakov.Lesson6.Homework6;

import java.util.Random;

public class Game {

    Doors doors = new Doors();
    Random random = new Random();

    public void newGame() {
        for (int i = 0; i < 3; i++) {
            doors.addDoor();
        }

        if (!doors.isContainsPrize(Prizes.CAR)) {
            doors.setDoor(random.nextInt(1, 4), Prizes.CAR);
        }

    }

    public boolean game(boolean chanGeChoice) {
        newGame();
        System.out.println("Start game");
        System.out.println(doors.getDoors());

        Integer playerChoice = random.nextInt(1, 4);
        System.out.println(playerChoice);

        Integer round1 = openDoor(playerChoice);
        Integer round2 = finalChoice(chanGeChoice, round1, playerChoice);

        return checkWin(round2);
    }

    private boolean checkWin(Integer playerChoice){
        if (doors.getPrize(playerChoice) != null && doors.getPrize(playerChoice).equals(Prizes.CAR)){
            System.out.println("Player Win!!!");
            return true;
        } else return false;
    }
    private Integer openDoor(Integer playerChoice) {
        while (true) {
            Integer door = random.nextInt(1, 4);
            if (!door.equals(playerChoice) && !checkWin(door)) {
                System.out.println("Open door: " + door);
                return door;
            }
        }
    }

    private Integer finalChoice(boolean changeChoice, Integer openDoor, Integer firstChoice) {
        if(changeChoice) {
            while (true) {
                Integer choice = random.nextInt(1, 4);
                if (!choice.equals(openDoor) && !choice.equals(firstChoice)) {
                    System.out.println("Player Choice: " + choice);
                    return choice;
                }
            }
        }
        return firstChoice;
    }
}
