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
        int first = 2, last = 5;
        int[] D;

        D = fillArray(7);

        if (first < 0 || last < 0 || first >= D.length || last >= D.length){

            System.out.println("Неверные значения индексов");

        }else {

            int sum;

            sum = getSumResult(D, first, last);

            System.out.println(Arrays.toString(D));
            System.out.println("Сумма элементов d["+first+"] - d["+last+"] равна: " + sum);
        }
    }

    private static int getSumResult(int[] d, int first, int last) {
        if (first > last){
            int tmp = last;
            last = first;
            first = tmp;
        }

        int sum = 0;

        for (int i = first; i <= last; i++) {
            sum += d[i];
        }

        return sum;
    }

    private static int[] fillArray(int size) {
        int[] array = new int[size];

        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(30) + 12;
        }

        return array;
    }
}
