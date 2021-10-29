package epam.java.chapter2.decomposition;

import java.util.Arrays;
import java.util.Random;

/**
 * Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
 * массива с номерами от k до m.
 */
public class Task8 {
    public static void main(String[] args) {
        int[] D;

        D = fillArray(7);

        System.out.println(Arrays.toString(D));

        getSumResult(D, 1);
        getSumResult(D, 3);
        getSumResult(D, 4);

    }

    private static void getSumResult(int[] d, int first) {
        int sum;
        int last;

        sum = 0;
        last = getLastIndex(d.length, first);

        for (int i = first; i < last; i++) {
            sum += d[i];
        }

        System.out.println("Сумма элементов d["+first+"] - d["+(last-1)+"] равна: " + sum);
    }

    private static int getLastIndex(int size, int first){
        int last;

        if ((first + 3) >= size){
            last = size;
        }else {
            last = first + 3;
        }

        return last;
    }

    private static int[] fillArray(int size) {
        int[] array;
        Random r;

        array = new int[size];
        r = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(30) + 12;
        }

        return array;
    }
}
