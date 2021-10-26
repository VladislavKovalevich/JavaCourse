package epam.java.chapter1.cycles;

import java.math.BigInteger;

/**
 * Составить программу нахождения произведения квадратов первых двухсот чисел.
 */

public class Task4 {
    public static void main(String[] args) {
        BigInteger num = BigInteger.ONE;

        for (int i = 2; i <= 200; i++){
            num = num.multiply(BigInteger.valueOf((long) i * i));
        }

        System.out.println(num);
    }
}
