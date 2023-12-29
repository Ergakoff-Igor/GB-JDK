package ru.gb.ergakov.Lesson4.Homework4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {

    private List<Employee> employes;

    public EmployeeBook() {
        employes = new ArrayList<>();
    }


    /**
     * Метод добавления сотрудника
     */
    public boolean add(Employee employee) {
        boolean flag = false;
        if (!employes.contains(employee)) {
            employes.add(employee);
            flag = true;
        }
        return flag;
    }

    /**
     * Метод вывода сотрудника
     */
    public Employee getEmployee(int index) {
        return contains(index) ? employes.get(index) : null;
    }

    /**
     * Метод проверки наличия екземпляра по индексу
     */
    public boolean contains (int index) {
        return employes != null
                && employes.size() > index;
    }

    /**
     * Метод, возвращающий длину списка сотрудников
     */
    public int count() {
        return employes.size();
    }

}
