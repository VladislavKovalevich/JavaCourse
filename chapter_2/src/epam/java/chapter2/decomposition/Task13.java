package epam.java.chapter2.decomposition;

import java.util.ArrayList;
import java.util.List;

/**
 * Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
 * решения задачи использовать декомпозицию.
 */
public class Task13 {
    public static void main(String[] args) {
        int n = 500;

        List<Integer> array;

        array = getTwinsNumbers(n);

        System.out.println("Количество пар близнецов = " + array.size() / 2);

        for (int i = 0; i < array.size(); i+= 2) {
            System.out.print(array.get(i) + "," + array.get(i + 1) + "  ");
        }
    }

    private static List<Integer> getTwinsNumbers(int n) {
        List<Integer> array = new ArrayList<>();

        for (int i = n; i <= 2*n; i++){
            if (isPrimalValue(i)){
                array.add(i);
            }
        }

        List<Integer> arrayTwins = new ArrayList<>();

        for (int i = 0; i < array.size() - 1; i += 2) {
            if (array.get(i) + 2 == array.get(i + 1)){
                arrayTwins.add(array.get(i));
                arrayTwins.add(array.get(i+1));
            }
        }

        return arrayTwins;
    }

    private static boolean isPrimalValue(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
