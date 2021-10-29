package epam.java.chapter2.decomposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
 * являются цифры числа N.
 */
public class Task10 {
    public static void main(String[] args) {
        int N;
        int[] array;

        N = 11324;
        array = getArrayFromNumber(N);

        System.out.println(Arrays.toString(array));
    }

    private static int[] getArrayFromNumber(int n) {
        int[] array;
        int arrSize;
        int i;

        arrSize = getDigitCount(n);
        array = new int[arrSize];

        while (n % 10 != 0){
            array[arrSize - 1] = n % 10;
            n = n / 10;
            arrSize--;
        }

        return array;
    }

    private static int getDigitCount(int n) {
        int count;

        count  = 0;

        while (n % 10 != 0){
            count++;
            n = n / 10;
        }

        return count;
    }
}
