package epam.java.chapter2.arrays;

import java.util.Arrays;

/**
 * Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
 * числом. Подсчитать количество замен.
 */
public class Task2 {
    public static void main(String[] args) {
        int Z;
        int[] A;
        int changeCount;

        Z = 75;
        A = new int[]{5, 36, 75, 4, 3, 76, 91, 0, 11};

        System.out.println("Исходная последовательность:\n" + Arrays.toString(A) + "\n");

        changeCount = 0;

        for (int i = 0 ; i < A.length; i++){
            if (A[i] > Z){
                A[i] = Z;
                changeCount ++;
            }
        }

        System.out.println("Результирующая последовательность:\n" + Arrays.toString(A) + "\n");
        System.out.println("Количество замен = " + changeCount);
    }
}
