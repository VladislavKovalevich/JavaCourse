package epam.java.chapter4.task1.entity;

public class Test1 {
    private int x;
    private int y;

    public Test1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
