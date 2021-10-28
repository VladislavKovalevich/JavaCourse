package epam.java.chapter1.cycles;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
 * m и n вводятся с клавиатуры.
 */

public class Task7 {
    public static void main(String[] args) {
        int m;
        int n;

        try (Scanner in = new Scanner(System.in)) {

            System.out.print("Введите m: ");
            m = in.nextInt();

            System.out.print("Введите n: ");
            n = in.nextInt();

            for (int i = m; i <= n; i++) {

                System.out.print(i + " - ");

                for (int j = 2; j < i; j++) {

                    if (i % j == 0) {
                        System.out.print(" " + j + " ");
                    }
                }

                System.out.print("\n");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода: введены не целочисленные данные");
        }
    }
}
