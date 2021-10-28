package epam.java.chapter1.linear;

/**
 * Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 * (sin x + cos y)/(cos x - sin y) * tg(x)
 */
public class Task3 {
    public static void main(String[] args) {
        double x;
        double y;

        double result;

        x = 1.41;
        y = 1.41;

        result = (Math.sin(x) + Math.cos(x)) /
                (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);

        System.out.println("Результат = " + result);
    }
}
