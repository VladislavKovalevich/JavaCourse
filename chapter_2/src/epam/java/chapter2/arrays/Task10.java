package epam.java.chapter2.arrays;

import java.util.Arrays;

/**
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */
public class Task10 {
    public static void main(String[] args) {
        int[] A;

        A = new int[]{-5, 36, 11, 4, -5, -5, 91, 9, 25, 1, 15 , 16 , 56};

        System.out.println("Исходная последовательность A:\n"+ Arrays.toString(A) +"\n");

        for (int i = 0; i < A.length; i++){
            if ((i + 1) % 2 == 0){
                A[i] = 0;
            }
        }

        int shift = 1;

        for (int i = 0; i< A.length && (shift + i) < A.length; i++){
            if (i != 0){
                A[i] = A[i + shift];
                A[i + shift] = 0;
                shift++;
            }
        }

        System.out.println("Результирующая последовательность A:\n"+ Arrays.toString(A) +"\n");

    }
}
