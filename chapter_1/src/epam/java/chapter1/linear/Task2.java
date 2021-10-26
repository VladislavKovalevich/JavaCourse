package epam.java.chapter1.linear;

/**
 * Вычислить значение выражения по формуле (все переменные принимают действительные значения).
 */
public class Task2 {
    public static void main(String[] args) {
        double a = 3.1;
        double b = 2.9;
        double c = 2.1;

        double result;

        result = (b + Math.sqrt(b * b + 4 * a * c)) / 2 * a
                - Math.pow(a, 3) * c + Math.pow(b, -2);

        System.out.println("Результат = " + result);
    }
}
