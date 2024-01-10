package ru.gb.java_core.task_main;

import java.time.LocalDate;

/**
 * Задание 1 - Создать класс сотрудник
 */
public class Employee {
    private String name;
    private String midName;
    private String surName;
    private String position;
    private String phone;
    double salary;
    int birth;

    public Employee(String name, String midName, String surName, String position, String phone,
                    int salary, int birth){
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birth = birth;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
       return LocalDate.now().getYear() - birth;
    }

    /**
     * Задание 2 - создать функцию выводящую всю информацию об объекте,
     * в т.ч. с использованием форматирования строк.
     * @return
     */

    @Override
    public String toString() {
        return infoFormat();
    }

    /**
     * Задание 2 - создать функцию выводящую всю информацию об объекте,
     * @return
     */
    public String info(){
        return ("Employee {" +
                "name = '" + name + "'" +
                ", midName = '" + midName + "'" +
                ", surName = '" + surName + "'" +
                ", position = '" + position + "'" +
                ", phone = '" + phone + "'" +
                ", salary = " + salary +
                ", age = " + getAge() + "}\n");
    }

    /**
     * Задание 2 - создать функцию выводящую всю информацию об объекте
     * с использованием форматирования строк
     */
    public String infoFormat(){
        return String.format("Employee {name = '%s'," +
                " midName = '%s'" +
                ", surName = '%s'" +
                ", position = '%s'" +
                ", phone = '%s'" +
                ", salary = %.2f" +
                ", age = %d }\n"
                , name
                , midName
                , surName
                , position
                , phone
                , salary
                , getAge());
    }

    /**
     * Задание 4** Написать метод повышения зарплаты
     * в качестве статического в классе сотрудников
     * @param employees - массив сотрудников
     * @param age - возрастное ограничение
     * @param amount - размер повышения зарплаты
     */
    public static void increaseSalary2(Employee[] employees, int age, int amount){
        for (Employee employee : employees) {
            if (employee.getAge() > age) {
                employee.setSalary(employee.getSalary() + amount);
            }
        }
    }

    /**
     * Домашнее задание 1 - Написать прототип компаратора -
     * метод внутри класса сотрудника, сравнивающий две даты, представленные в виде
     * трех чисел гггг-мм-дд, без использования условного оператора
     * @param s_date1
     * @param s_date2
     * @return
     */
    public static int compareDate(String s_date1, String s_date2){
        int i_date1 = Integer.parseInt(s_date1.replace("-", ""));
        int i_date2 = Integer.parseInt(s_date2.replace("-", ""));

        return Integer.compare(i_date1, i_date2);
    }

}
