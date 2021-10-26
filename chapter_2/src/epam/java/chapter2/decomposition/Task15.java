package epam.java.chapter2.decomposition;

import java.util.ArrayList;
import java.util.List;

/**
 * Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */
public class Task15 {
    public static void main(String[] args) {
        int n = 4;

        List<Long> list = new ArrayList<>();

        nextNumber(0,0, 0, n - 1, list);

        for (Long l: list) {
            System.out.print(l + "; ");
        }
    }

    private static void nextNumber(int number, long num, int count, int n, List<Long> list) {
        long s;

        if (number < 9){

            for (int i = number + 1; i <= 9; i++) {
                s = num * 10 + i;

                if (count == n) {
                    list.add(s);
                }

                nextNumber(i, s, count + 1, n, list);
            }
        }

    }


}
