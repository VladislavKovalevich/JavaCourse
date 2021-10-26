package epam.java.chapter1.branching;

import java.util.Scanner;

/**
 * Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
 * отверстие.
 */

public class Task4 {
    public static void main(String[] args) {
        int A;
        int B;
        int x;
        int y;
        int z;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите размеры отверстия: ");
        System.out.print("Параметр А: ");
        A = in.nextInt();

        System.out.print("Параметр В: ");
        B = in.nextInt();

        System.out.println("Введите размеры кирпича: ");
        System.out.print("Параметр x: ");
        x = in.nextInt();

        System.out.print("Параметр y: ");
        y = in.nextInt();

        System.out.print("Параметр z: ");
        z = in.nextInt();

        if ((x <= A && y <= B) || (y <= A && z <= B) ||
            (x <= A && z <= B)){
            System.out.println("Результат = " + true);
        }else{
            System.out.println("Результат = " + false);
        }

    }
}
