package ru.gb.java_core.task_main;

import java.util.Arrays;

public class Main {

    /**
     * Домашнее задание к семинару 3 - задачи 1 и 2
     * Основной метод - точка входа.
     * @param args
     *
     */
    public static void main(String[] args) {
        Employee ivan = new Employee("Иван", "Иванович",
                "Иванов", "java разработчик",
                "8(812)111-11-11", 200000, 1985);
        Employee olga = new Employee("Ольга", "Викторовна",
                "Викторова", "проектировщик интерфейсов", "8(812)111-11-22",
                180000, 1987);
        Employee sergey = new Employee("Сергей", "Сергеевич",
                "Сергеев", "тестировщик", "8(812)111-11-33",
                160000, 1990);
        Employee natalia = new Employee("Наталья", "Алексеевна",
                "Алексеева", "аналитик", "8(812)111-11-44",
                170000, 1975);
        Employee petr = new Employee("Петр", "Петрович",
                "Петров", "старший разработчик", "8(812)111-11-55",
                250000, 1976);
        Boss semen = new Boss("Семен", "Семенович",
                "Семенов", "руководитель", "8(812)111-11-00",
                300000, 1970);

        // Задача 3 - создать массив из 5 сотрудников
        Employee[] employees = {ivan, olga, sergey, natalia, petr, semen};
        System.out.println("\nИсходный список сотрудников:");
        printCompany(employees);

        // Задание 4 - повыcить зарплату всем сотрудникам старше 45 лет на 5000.
        increaser(employees);
        System.out.println("Список сотрудников после первого повышения зарплаты сотрудникам старше 45 лет на 5000:");
        printCompany(employees);

        // Задание 4* - Повысить зарплату сотрудникам. Возраст и размер повышения должны быть параметрами метода
        increaser2(employees, 40, 3333);
        System.out.println("Список сотрудников после второго повышения зарплаты сотрудникам старше 40 лет на 3333:");
        printCompany(employees);

        // Задание 4** Повысить зарплату сотрудникам с использованием статистического метода в классе сотрудников
        Employee.increaseSalary2(employees,37, 11111);
        System.out.println("Список сотрудников после третьего повышения зарплаты сотрудникам старше 37 лет на 11111:");
        printCompany(employees);

        // Задание 5 - Вычислить средний возраст сотрудников
        System.out.println("Средний возраст сотрудников: " + averageAge(employees));

        // Задание 5 - Вычислить среднюю зарплату сотрудников
        System.out.println("Средняя зарплата сотрудников: " + averageSalary(employees));

        // Задание 5 - сравнить две даты с использование компаратора в классе сотрудников
        System.out.println("Сравнение двух дат: " + Employee.compareDate("2023-12-31", "2024-01-01"));

        // Домашнее задание 2 - Повысить зарплату всем сотудникам кроме руководителя
        Boss.increaseSalaryByBoss(employees, 0, 11111);
        System.out.println("\nСписок сотрудников после 4 повышения зарплаты всем сотрудникам кроме руководителя на 11111:");
        printCompany(employees);

    }

    /**
     * Задание 4 - создать
     * Метод повышающий зарплату всем сотрудникам
     * старше 45 лет на 5000.
     * @param emp - список (массив) сотрудников
     */
    private static void increaser(Employee[] emp){
        for (Employee employee : emp) {
            if (employee.getAge() > 45) {
                employee.setSalary(employee.getSalary() + 5000);
            }
        }
    }

    /**
     * Задание 4* - Написать Метод повышения зарплаты сотрудникам,
     * но возраст и размер повышения должны быть параметрами метода
     * @param employees - массив сотрудников
     * @param age - максимальный возраст сотрудников, которым не повышается зарплата
     * @param amount - размер увеличения зарплаты
     */
    private static void increaser2(Employee[] employees, int age, double amount){
        for (Employee employee : employees) {
            if (employee.getAge() > age) {
                employee.setSalary(employee.getSalary() + amount);
            }
        }
    }

    /**
     * Задание 5 - написать метод
     * вычисляющий средний возраст сотрудников
     * @param employees - массив сотрудников
     * @return возвращает средний возраст сотрудников
     */
    private static double averageAge(Employee[] employees){
        return Arrays.stream(employees)
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);

    }

    /**
     * Задание 5 - написать метод
     * вычисляющий среднюю заработную плату сотрудников
     * @param employees  - массив сотрудников
     * @return возвращает среднее значение зарплаты
     */
    private static double averageSalary(Employee[] employees){
        return Arrays.stream(employees)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

    }

    /**
     * Метод вывода на печать всех сотрудников
     * @param employees - массив сотрудников
     */
     private static void printCompany(Employee[] employees){
         System.out.println("\n");
         Arrays.stream(employees).forEach(System.out::println);
         System.out.println("\n");
     }

}
