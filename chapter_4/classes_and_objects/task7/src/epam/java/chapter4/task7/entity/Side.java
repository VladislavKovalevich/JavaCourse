package epam.java.chapter4.task7.entity;

public class Side {
    private Point begin;
    private Point end;
    private double length;

    public Side(Point begin, Point end){
        this.begin = begin;
        this.end = end;
        this.length = Math.sqrt(Math.pow((end.getX() - begin.getX()), 2) + Math.pow((end.getY() - begin.getY()), 2));
    }

    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
