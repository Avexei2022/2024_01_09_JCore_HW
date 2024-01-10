package ru.gb.java_core.task_additional.service;

import ru.gb.java_core.task_additional.Student;

import java.util.Comparator;

public class StudentComparator<T extends Student> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
    }
}
