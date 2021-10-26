package epam.java.chapter1.cycles;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */

public class Task8 {
    public static void main(String[] args) {
        int m;
        int n;

        try (Scanner in = new Scanner(System.in)) {

            System.out.print("Введите m: ");
            m = in.nextInt();

            System.out.print("Введите n: ");
            n = in.nextInt();

            int currNValue, currMValue;

            if (n > 0 && m > 0) {

                while (n > 0) {

                    currNValue = n % 10;
                    n = n / 10;

                    currMValue = m;

                    while (currMValue > 0) {

                        if (currMValue % 10 == currNValue) {
                            System.out.print(currNValue + " ");
                        }

                        currMValue = currMValue / 10;
                    }
                }

            } else {

                System.out.println("Ошбика ввода");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода");
        }
    }
}
