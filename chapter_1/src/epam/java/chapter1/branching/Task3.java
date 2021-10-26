package epam.java.chapter1.branching;

import java.util.Scanner;

/**
 * Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
 */

public class Task3 {
    public static void main(String[] args) {
        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты первой точки: ");
        System.out.print("Ввведтие координату x: ");
        x1 = in.nextInt();

        System.out.print("Ввведтие координату y: ");
        y1 = in.nextInt();

        System.out.println("Введите координаты второй точки: ");
        System.out.print("Ввведтие координату x: ");
        x2 = in.nextInt();

        System.out.print("Ввведтие координату y: ");
        y2 = in.nextInt();

        System.out.println("Введите координаты третей точки: ");
        System.out.print("Ввведтие координату x: ");
        x3 = in.nextInt();

        System.out.print("Ввведтие координату y: ");
        y3 = in.nextInt();


        int x12 = x1 - x2;
        int y12 = y1 - y2;

        int x13 = x1 - x3;
        int y13 = y1 - y3;

        if (x12 != 0 && y12 != 0) {
            if (x13 / x12 == y13 / y12) {
                System.out.println("Заданные точки расположены на одной прямой");
            } else {
                System.out.println("Заданные точки не расположены на одной прямой");
            }
        }else{
            System.out.println("Ошибка деления на ноль");
        }
    }
}
