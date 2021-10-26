package epam.java.chapter2.matrix;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */
public class Task3 {
    public static void main(String[] args) {
        int []  matrix[] = new int[7][3];

        Random r = new Random();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print(" "+ matrix[i][j] + " ");
            }

            System.out.println();
        }

        int col, row;

        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите номер столбца: ");
            col = in.nextInt();

            System.out.print("Введите номер строки: ");
            row = in.nextInt();

            if (col >= 0 && row >= 0){
                System.out.print("Строка " + row + " :");
                for (int i = 0; i < matrix[row].length; i++){
                    System.out.print(matrix[row][i] + " ");
                }

                System.out.println();

                System.out.print("Столбец " + col + " :");
                for (int i = 0; i < matrix.length; i++){
                    System.out.print(matrix[i][col] + " ");
                }
            }

        } catch (InputMismatchException ex) {
            System.out.println("ошибка ввода");
        }
    }
}
