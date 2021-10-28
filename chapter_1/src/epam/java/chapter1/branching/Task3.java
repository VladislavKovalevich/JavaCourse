package epam.java.chapter1.branching;

/**
 * Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
 */

public class Task3 {
    public static void main(String[] args) {
        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;

        x1 = 1;
        y1 = 1;
        x2 = 2;
        y2 = 2;
        x3 = 0;
        y3 = 0;


        int x12 = x1 - x2;
        int y12 = y1 - y2;

        int x13 = x1 - x3;
        int y13 = y1 - y3;

        if (x13 * y12 == y13 * x12) {
                System.out.println("Заданные точки расположены на одной прямой");
            } else {
                System.out.println("Заданные точки не расположены на одной прямой");
            }
        }
}
