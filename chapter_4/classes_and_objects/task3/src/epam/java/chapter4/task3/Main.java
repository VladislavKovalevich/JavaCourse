package epam.java.chapter4.task3;

import epam.java.chapter4.task3.action.StudentAction;
import epam.java.chapter4.task3.entity.Student;

import java.util.List;

/**
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alekseev A.A.", "851001", new int[]{9,9,9,9,9}),
                new Student("Bobrov E.S.", "851002", new int[]{7,7,10,10,9}),
                new Student("Shelby W.S.", "651006", new int[]{7,9,9,9,9}),
                new Student("Kutuzow M.I.", "451001", new int[]{7,9,9,8,9}),
                new Student("Abramov Sh.A.", "551003", new int[]{7,8,6,8,9}),
                new Student("Mihailov S.W.", "451009", new int[]{7,8,6,8,9}),
                new Student("Zubow W.W.", "151007", new int[]{7,9,6,8,9}),
                new Student("Kuznetsow A.E.", "451001", new int[]{9,9,9,9,9}),
                new Student("Saharow B.W.", "751004", new int[]{10,10,9,9,9})
        };

        StudentAction studentAction = new StudentAction();
        List<Student> bestStudents;

        bestStudents = studentAction.getBestStudents(students);

        System.out.println(studentAction.getStringFromBestStudentList(bestStudents));
    }
}
