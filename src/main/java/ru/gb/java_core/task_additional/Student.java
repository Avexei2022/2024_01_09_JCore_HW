package ru.gb.java_core.task_additional;

import java.util.List;

public class Student{
    private String name;
    private List<Double> grades;
    private String speciality;

    public Student(String name, List<Double> grades, String speciality) {
        this.name = name;
        this.grades = grades;
        this.speciality = speciality;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public String getSpeciality() {
        return speciality;
    }

    public double getAverageGrade(){
        return grades.stream()
                .mapToDouble(value -> value)
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        return "Студент{" +
                "имя ='" + name + '\'' +
                ", оценки =" + grades +
                ", специальность ='" + speciality + '\'' +
                ", средний балл ='" + getAverageGrade() + '\'' +
                '}' + "\n";
    }

}
