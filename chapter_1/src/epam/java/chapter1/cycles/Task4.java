package epam.java.chapter1.cycles;

/**
 * Составить программу нахождения произведения квадратов первых двухсот чисел.
 */

public class Task4 {
    public static void main(String[] args) {
        long result;

        result = 1;

        for (long i = 2; i <= 200; i++){
            result *= Math.pow(i, 2);
        }

        System.out.println(result);
    }
}
