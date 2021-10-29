package epam.java.chapter2.arrays;

import java.util.Arrays;

/**
 * Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */
public class Task5 {
    public static void main(String[] args) {
        int[] A;

        A= new int[]{-1, 36, 75, -4, 3, -76, 91, 0, 1};

        System.out.println("Исходная последовательность:\n"+ Arrays.toString(A) +"\n");

        System.out.print("Результат: ");
        for (int i = 0 ; i < A.length; i++){
            if (A[i] > i){
                System.out.print(A[i] + " ");
            }
        }
    }
}
