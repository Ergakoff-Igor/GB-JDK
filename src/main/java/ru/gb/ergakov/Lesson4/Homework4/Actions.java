package ru.gb.ergakov.Lesson4.Homework4;


import java.util.ArrayList;
import java.util.List;

public class Actions {
    private EmployeeBook currentBook = new EmployeeBook();
    private ConsoleView view = new ConsoleView();

    /**
     * Метод добавления сотрудника
     */
    public void addEmployee() {
        System.out.println("Добавление контакта:\n");
        currentBook.add(
                new Employee(view.inputID(),
                        new Phones().addPhone(view.inputPhoneNumber()),
                        view.inputName(), view.inputExperience()));
    }

    /**
     * Метод вывода сотрудников по стажу
     */
    public void findEmployeeByExperience() {
        boolean flag = false;
        int findExperience = view.inputExperience();
        List<Employee> resultArray = new ArrayList<>();
        for (int i = 0; i < currentBook.count(); i++) {
            if (currentBook.getEmployee(i).getExperience() == findExperience) {
                resultArray.add(currentBook.getEmployee(i));
                flag = true;
            }
        }

        if (flag) {
            for (Employee line : resultArray) {
                System.out.println(line);
            }
        } else System.out.printf("Сотрудник со стажем '%d лет' не найден", findExperience);
    }

    /**
     * Метод вывода номеров телефона сотрудника по имени
     */
    public void findPhonesByName() {
        System.out.println(findEmployeeByName().getPhonesNumber());
    }

    /**
     * Метод поиска сотрудника по табельному номеру
     */
    public void findEmployeeByIDNumber() {
        int findID = view.inputID();
        try {
            for (int i = 0; i < currentBook.count(); i++) {
                if (currentBook.getEmployee(i).getIdNumber() == findID) {
                    System.out.println(currentBook.getEmployee(i));
                    break;
                }
            }
        } catch (RuntimeException e) {
            System.out.printf("Сотрудник с табельным номером" + findID + " не найден");
        }
    }

    /**
     * Метод добавления номера телефона
     */
    public void addPhone() {
        for (int i = 0; i < currentBook.count(); i++) {
            if (currentBook.getEmployee(i).equals(findEmployeeByName())) {
                currentBook.getEmployee(i).addPhone(view.inputPhoneNumber());
                break;
            }
        }
    }

    /**
     * Метод поиска сотрудника по имени
     */
    public Employee findEmployeeByName() {
        String findName = view.inputName();
        try {
            for (int i = 0; i < currentBook.count(); i++) {
                if (currentBook.getEmployee(i).getName().equals(findName)) {
                    return currentBook.getEmployee(i);
                }
            }
        } catch (RuntimeException e) {
            System.out.printf("Сотрудник с именем" + findName + " не найден");
        }
        return null;
    }
}
