package epam.java.chapter1.branching;

/**
 * Вычислить значение функции
 */
public class Task5 {
    public static void main(String[] args) {
        int x;
        double y;

        x = 4;

        if (x <= 3){
            y = (int) Math.pow(x, 2.0) - 3*x + 9;
        }else {
            y = 1.0 / ((int) Math.pow(x, 3.0) + 6);
        }

        System.out.println("F(x) = " + y);
    }
}
