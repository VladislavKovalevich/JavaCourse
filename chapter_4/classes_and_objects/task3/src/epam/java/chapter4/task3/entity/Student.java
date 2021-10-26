package epam.java.chapter4.task3.entity;

public class Student {
    private String name;
    private String groupNumber;
    private int[] progress;

    public Student(String name, String groupNumber, int[] progress){
        this.name = name;
        this.groupNumber = groupNumber;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }
}
