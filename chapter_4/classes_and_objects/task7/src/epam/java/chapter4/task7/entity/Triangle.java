package epam.java.chapter4.task7.entity;

public class Triangle {
    private Side a;
    private Side b;
    private Side c;

    public Triangle(Point a, Point b, Point c) {
        this.a = new Side(a, b);
        this.b = new Side(b, c);
        this.c = new Side(c, a);
    }

    public Side getA() {
        return a;
    }

    public void setA(Side a) {
        this.a = a;
    }

    public Side getB() {
        return b;
    }

    public void setB(Side b) {
        this.b = b;
    }

    public Side getC() {
        return c;
    }

    public void setC(Side c) {
        this.c = c;
    }
}
