package epam.java.chapter2.decomposition;

import java.util.ArrayList;
import java.util.List;

/**
 * Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
 * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
 * использовать декомпозицию.
 */
public class Task14 {
    public static void main(String[] args) {
        int k = 500;

        List<Integer> array;

        array = getArmstrongNumbers(k);

        for (Integer item: array) {
            System.out.print(item + "; ");
        }
    }

    private static List<Integer> getArmstrongNumbers(int k) {
        List<Integer> array = new ArrayList<>();

        for (int i = 1; i < k; i++) {
            if (isArmstrongNumber(i)){
                array.add(i);
            }
        }

        return  array;
    }

    private static boolean isArmstrongNumber(int i) {
        return getNumberValue(i) == i;
    }

    private static int getCountNumber(int i){
        int counter = 0;

        while (i != 0){
            counter++;
            i = i / 10;
        }

        return counter;
    }

    private static int getNumberValue(int i) {
        int sum = 0;
        int counter = getCountNumber(i);


        while (i != 0){
            sum += Math.pow(i % 10,counter);
            i = i / 10;
        }

        return sum;
    }
}
