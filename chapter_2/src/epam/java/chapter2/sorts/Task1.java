package epam.java.chapter2.sorts;

import java.util.Arrays;

/**
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив.
 */
public class Task1 {
    public static void main(String[] args) {
        int k;
        int[] arraySrc;
        int[] arrayDest;
        int[] summaryArray;

        k = 5;
        arraySrc = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        arrayDest = new int[]{8, 8, 8, 8, 8};
        summaryArray = new int[arrayDest.length + arraySrc.length];

        System.arraycopy(arraySrc, 0, summaryArray, 0, k);
        System.arraycopy(arrayDest, 0, summaryArray, k, arrayDest.length);
        System.arraycopy(arraySrc, k, summaryArray, k + arrayDest.length, arraySrc.length - k);

        System.out.println(Arrays.toString(summaryArray));
    }
}