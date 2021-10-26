package epam.java.chapter2.decomposition;

import java.util.ArrayList;
import java.util.List;

/**
 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
 * являются числа, сумма цифр которых равна К и которые не большее N.
 */
public class Task12 {
    public static void main(String[] args) {
        int K = 10;
        int N = 78;

        List<Integer> array;

        array = fillArray(K, N);

        System.out.println("Количество элементов = "+array.size());

        for (Integer s:array) {
            System.out.print(s + " ");
        }
    }

    private static List<Integer> fillArray(int k, int n) {
        List<Integer> array = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (getSum(i) == k){
                array.add(i);
            }
        }

        return array;
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
