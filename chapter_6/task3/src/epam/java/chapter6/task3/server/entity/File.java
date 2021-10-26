package epam.java.chapter6.task3.server.entity;

import java.util.HashMap;
import java.util.Map;

public class File {
    private int id;
    private Student student;
    private Map<TestSubjectType,Integer> subjectMap = new HashMap<>();

    public File(){


    }

    public File(int id, Student student, Map<TestSubjectType, Integer> subjectMap) {
        this.id = id;
        this.student = student;
        this.subjectMap = subjectMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<TestSubjectType, Integer> getSubjectMap() {
        return subjectMap;
    }

    public void setSubjectMap(Map<TestSubjectType, Integer> subjectMap) {
        this.subjectMap = subjectMap;
    }

    @Override
    public String toString() {
        return "\nДело №" + id +
                "\nstudent = " + student +
                "\nsubjectMap = " + subjectMap.toString() +
                "\n";
    }
}
