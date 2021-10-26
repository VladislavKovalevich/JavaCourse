package epam.java.chapter2.decomposition;

import java.util.ArrayList;
import java.util.List;

/**
 * Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
 * являются цифры числа N.
 */
public class Task10 {
    public static void main(String[] args) {
        int N = 124143;

        List<Integer> array;

        array = getArrayFromNumber(N);

        for (Integer s:array) {
            System.out.print(s + " ");
        }
    }

    private static List<Integer> getArrayFromNumber(int n) {
        List<Integer> array = new ArrayList<>();

        while (n % 10 != 0){
            array.add(n % 10);
            n = n / 10;
        }

        return array;
    }
}
