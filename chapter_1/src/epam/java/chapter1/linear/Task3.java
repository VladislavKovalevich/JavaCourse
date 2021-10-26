package epam.java.chapter1.linear;

/**
 *  Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 * 𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦
 * 𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦
 * ∗ 𝑡𝑔 𝑥�
 */
public class Task3 {
    public static void main(String[] args) {
        double x = 1.41;
        double y = 1.41;

        double result;

        result = (Math.sin(x) + Math.cos(x)) /
                (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);

        System.out.println("Результат = " + result);
    }
}
