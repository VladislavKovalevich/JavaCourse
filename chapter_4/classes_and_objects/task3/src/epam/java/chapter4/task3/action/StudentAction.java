package epam.java.chapter4.task3.action;

import epam.java.chapter4.task3.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAction {

    public StudentAction(){

    }

    public List<Student> getBestStudents(Student[] students){
        List<Student> studentList = new ArrayList<>();
        int[] notes;
        boolean isGoodStudent;

        for (int i = 0; i < students.length; i++) {

            isGoodStudent = true;
            notes = students[i].getProgress().clone();

            for (int j = 0; j < notes.length; j++) {

                if (notes[j] < 9){
                    isGoodStudent = false;
                    break;
                }

            }

            if (isGoodStudent){
                studentList.add(students[i]);
            }

        }

        return studentList;
    }

    public String getStringFromBestStudentList(List<Student> students){
        StringBuilder stringBuilder = new StringBuilder();

        for (Student student : students) {
            stringBuilder.append(student.getName());
            stringBuilder.append(" ").append(student.getGroupNumber());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
