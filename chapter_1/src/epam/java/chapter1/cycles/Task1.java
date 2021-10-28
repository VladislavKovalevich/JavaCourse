package epam.java.chapter1.cycles;

import java.util.Scanner;

/**
 * Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
 * все числа от 1 до введенного пользователем числа.
 */
public class Task1 {
    public static void main(String[] args) {
        int arg;
        String message;
        Scanner in;

        message = "Введите число а: ";
        in = new Scanner(System.in);

        System.out.print(message);

        while (!in.hasNextInt()){
            in.next();

            System.out.println(message);
        }

        arg = in.nextInt();

        if (arg > 0) {
            int sum = 0;
            for (int i = 1; i <= arg; i++) {
                sum += i;
            }

            System.out.println("Результат = " + sum);
        } else {
            System.out.println("Число не натуральное");
        }
    }
}
