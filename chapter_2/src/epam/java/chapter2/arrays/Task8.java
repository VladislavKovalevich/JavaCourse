package epam.java.chapter2.arrays;

import java.util.Arrays;

/**
 * Дана последовательность целых чисел a1, a2, ..., an.
 * Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min( a1, a2, ..., an).
 */
public class Task8 {
    public static void main(String[] args) {
        int[] A;
        int minValue;
        int minValueCount;

        A = new int[]{-5, 36, -5, 4, -5, -5, 91, 9, -5, 1};
        minValue = Integer.MAX_VALUE;
        minValueCount = 0;

        for (int i = 0; i < A.length; i++){
            if (A[i] < minValue)
                minValue = A[i];
        }

        for (int i = 0; i < A.length; i++){
            if (minValue == A[i]){
                minValueCount++;
            }
        }

        int[] B;
        int j;

        B = new int[A.length - minValueCount];
        j = 0;

        for (int i = 0; i < A.length; i++){
            if (A[i] != minValue){
                B[j] = A[i];
                j++;
            }
        }

        System.out.println("Исходная последовательность A:\n"+ Arrays.toString(A) +"\n");
        System.out.println("Результирующая последовательность В:\n"+ Arrays.toString(B) +"\n");
    }
}
