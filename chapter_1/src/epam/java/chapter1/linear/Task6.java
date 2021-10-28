package epam.java.chapter1.linear;

/**
 * Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
 * принадлежит закрашенной области, и false — в противном случае.
 */
public class Task6 {
    public static void main(String[] args) {
        int x;
        int y;

        boolean f1;
        boolean f2;
        boolean result;

        x = 0;
        y = 0;

        f1 = (x <= 4 && x >= -4) && (y <= 0 && y >= -3);
        f2 = (x <= 2 && x >= -2) && (y >= 0 && y <= 4);

        result = f1 || f2;

        System.out.println("Результат = "+ result);
    }
}
