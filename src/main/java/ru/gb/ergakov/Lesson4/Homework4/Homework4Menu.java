package ru.gb.ergakov.Lesson4.Homework4;


import ru.gb.ergakov.UI.InterSeminarMenu;




public class Homework4Menu extends Thread {
    Actions actions = new Actions();
    private ConsoleView cv = new ConsoleView();

    public void run () {

       while (true) {
           switch (cv.inputAction()) {
               case 1 -> actions.addEmployee();
               case 2 -> actions.findEmployeeByExperience();
               case 3 -> actions.findPhonesByName();
               case 4 -> actions.findEmployeeByIDNumber();
               case 5 -> actions.addPhone();
               case 0 -> System.exit(0);
           }
       }
   }
}
