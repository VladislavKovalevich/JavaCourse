package epam.java.chapter2.decomposition;

import java.util.Arrays;
import java.util.Random;

/**
 * Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
 * которое меньше максимального элемента массива, но больше всех других элементов).
 */
public class Task5 {
    public static void main(String[] args) {
        int N = 10;
        int[] A;

        A = fillArray(N);

        int maxValue;

        maxValue = getMaxItem(A);

        int prevMaxValue;

        prevMaxValue = getPrevMaxValue(maxValue, A);

        System.out.println(Arrays.toString(A));
        System.out.println(prevMaxValue);
    }

    private static int getPrevMaxValue(int maxItem, int[] array) {
        int prevMaxValue = -1000;

        for (int i = 0; i < array.length; i++) {
            if (maxItem != array[i] && prevMaxValue < array[i]){
                prevMaxValue = array[i];
            }
        }

        return prevMaxValue;
    }

    private static int getMaxItem(int[] array) {
        int maxValue = array[0];

        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]){
                array[i] = maxValue;
            }
        }

        return maxValue;
    }

    private static int[] fillArray(int N){
        int[] array = new int[N];

        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(20) + 14;
        }

        return array;
    }
}
