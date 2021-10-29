package epam.java.chapter2.sorts;

import java.util.Arrays;

/**
 * Сортировка обменами. Дана последовательность чисел.
 * Требуется переставить числа в порядке возрастания.
 * Для этого сравниваются два соседних числа a[i] и a[i+1].
 * Если a[i] > a[i+1], то делается перестановка.
 * Так продолжается до тех пор, пока все элементы не станут
 * расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 */
public class Task4 {
    public static void main(String[] args) {
        int[] array;
        int permutationCount;

        array = new int[]{55, 34, 11, 6, 4, 4, 3, 2, 1, 0};
        permutationCount = 0;


        for (int i = 0; i < array.length - 1; i++) {

            for (int j = array.length - 1; j > i; j--) {

                if (array[j - 1] > array[j]){

                    int temp;
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                    permutationCount++;
                }

            }

        }

        System.out.println(Arrays.toString(array));

        System.out.println("\nКоличество перестановок = "+ permutationCount);

    }
}
