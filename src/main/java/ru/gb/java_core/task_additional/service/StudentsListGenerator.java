package ru.gb.java_core.task_additional.service;

import ru.gb.java_core.task_additional.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentsListGenerator {

    public StudentsListGenerator() {
    }

    /**
     * Генератор списка студентов
     * @param numberOfStudents - общее количество студентов
     * @param numberOfRatings - количество оценок у каждого студента
     * @param specialities - специальность
     * @return - список студентов
     */
    public ArrayList<Student> getStudentsList(int numberOfStudents, int numberOfRatings, String [] specialities){
        ArrayList<Student> studentsList = new ArrayList<>();
        RandomName randomName = new RandomName(7);
            for (int i = 0; i < numberOfStudents; i++){
                String name = randomName.getNameRusByStringShort();
                List<Double> grades = new ArrayList<>();
                for (int j = 0; j < numberOfRatings; j++)
                    grades.add((double) new Random().nextInt(4, 6));
                String speciality = specialities[i %specialities.length];
                Student student = new Student(name, grades, speciality);
                studentsList.add(student);
            }
        return studentsList;
    }

}
