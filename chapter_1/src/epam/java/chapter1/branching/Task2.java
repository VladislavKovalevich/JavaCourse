package epam.java.chapter1.branching;

import java.util.Scanner;

/**
 * Найти max{min(a, b), min(c, d)}
 */

public class Task2 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число a: ");
        a = in.nextInt();

        System.out.print("Введите число b: ");
        b = in.nextInt();

        System.out.print("Введите число c: ");
        c = in.nextInt();

        System.out.print("Введите число d: ");
        d = in.nextInt();

        int minAB, minCD;

        if (a <= b){
            minAB = a;
        }else
            minAB = b;

        if (c <= d){
            minCD = c;
        }else
            minCD = d;

        if (minAB > minCD){
            System.out.println("результат = " + minAB);
        }else
            System.out.println("результат = "+ minCD);

    }
}
