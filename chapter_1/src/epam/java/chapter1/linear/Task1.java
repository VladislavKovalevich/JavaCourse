package epam.java.chapter1.linear;

/**
 * Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
 */
public class Task1 {
    public static void main(String[] args) {
        double a;
        double b;
        double c;

        double result;

        a = 3.1;
        b = 2.9;
        c = 2.1;

        result = ((a - 3) * b / 2) + c;

        System.out.println("Результат = " + result);
    }
}
