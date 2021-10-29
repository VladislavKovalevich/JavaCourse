package epam.java.chapter2.decomposition;

import java.util.Arrays;

/**
 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
 * являются числа, сумма цифр которых равна К и которые не большее N.
 */
public class Task12 {
    public static void main(String[] args) {
        int K;
        int N;

        int[] array;

        K = 10;
        N = 78;

        array = fillArray(K, N);

        System.out.println(Arrays.toString(array));
    }

    private static int[] fillArray(int k, int n) {
        int[] array;
        int size;
        int index;

        size = getArraySize(k, n);
        array = new int[size];
        index = 0;

        for (int i = 1; i <= n; i++) {
            if (getSum(i) == k){
                array[index++] = i;
            }
        }

        return array;
    }

    private static int getArraySize(int k, int n) {
        int count;

        count = 0;

        for (int i = 1; i <= n; i++) {
            if (getSum(i) == k){
                count++;
            }
        }

        return count;
    }

    private static int getSum(int i) {
        int s = 0;

        while (i != 0){
            s = s + i % 10;
            i = i / 10;
        }

        return s;
    }
}
