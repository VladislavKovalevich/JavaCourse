package epam.java.chapter1.cycles;

/**
 * Найти сумму квадратов первых ста чисел.
 */

public class Task3 {
    public static void main(String[] args) {
        int sum;

        sum = 0;

        for (int i = 1; i <= 100; i++){
            sum += i * i;
        }

        System.out.println("Результат = "+ sum);
    }
}
