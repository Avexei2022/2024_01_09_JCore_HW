package ru.gb.java_core.task_additional;

import ru.gb.java_core.task_additional.service.StudentComparator;
import ru.gb.java_core.task_additional.service.StudentsListGenerator;

import java.util.ArrayList;

public class MainAdditional {

    /**
     * Основной метод дополнительного задания
     * @param args
     *
     */
    public static void main(String[] args) {
        String[] specialities = new String[]{"Информатика", "Математика", "Физика", "Химия"};
        StudentsListGenerator studentsListGenerator = new StudentsListGenerator();
        ArrayList<Student> studentArrayList = studentsListGenerator.getStudentsList(50, 10, specialities);

        System.out.println("Полный список студентов:\n");
        studentArrayList.forEach(System.out::println);

        System.out.println("Список первых 5-ти студентов специальности Информатика со средним баллом выше 4,5:\n");
        studentArrayList.stream()
                .filter(student -> student.getSpeciality().equals("Информатика")
                        && student.getAverageGrade() > 4.5)
                            .sorted(new StudentComparator<>().reversed())
                            .limit(5)
                            .forEach(System.out::println);
    }
}
