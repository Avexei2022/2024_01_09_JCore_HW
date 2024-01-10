package ru.gb.java_core.task_main;

/**
 * Домашнее задание 2 - Опишите класс руководителя, наследник от сотрудника.
 */
public class Boss extends Employee{

    public Boss(String name, String midName, String surName, String position, String phone, int salary, int birth) {
        super(name, midName, surName, position, phone, salary, birth);
    }

    /**
     *  Домашнее задание 2 - Перенесите статический метод повышения зарплаты в класс руководителя,
     *  модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
     * @param employees - массив сотрудников
     * @param age - возрастное ограничение
     * @param amount - размер повышения зарплаты
     */
    public static void increaseSalaryByBoss(Employee[] employees, int age, int amount){

        for (Employee employee : employees) {
            if (employee.getAge() > age && !(employee instanceof Boss)) {
                employee.setSalary(employee.getSalary() + amount);
            }
        }
    }
}
