package epam.java.chapter6.task3.server.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private int groupNumber;
    private Date birthDate;

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");

    public Student() {
    }

    public Student(String name, String surname, int groupNumber, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.groupNumber = groupNumber;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupNumber=" + groupNumber +
                ", birthDate=" + birthDate +
                '}';
    }
}
