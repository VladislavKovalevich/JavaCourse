package epam.java.chapter2.matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */
public class Task3 {
    public static void main(String[] args) {
        int []  matrix[];
        int col;
        int row;
        Scanner in;
        Random r;

        matrix = new int[7][3];
        r = new Random();

        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print(" "+ matrix[i][j] + " ");
            }

            System.out.println();
        }



        in = new Scanner(System.in);

        while (true) {
            int curr;

            System.out.print("Введите номер столбца: ");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("Введите номер столбца: ");
            }

            curr = in.nextInt();
            if (curr <= matrix[0].length){
                col = curr;
                break;
            }else {
                System.out.println("Вход за пределы матрцы!");
            }
        }

        while (true) {
            int curr;

            System.out.print("Введите номер строки: ");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("Введите номер строки: ");
            }
            curr = in.nextInt();
            if (curr <= matrix.length){
                row = curr;
                break;
            }else {
                System.out.println("Вход за пределы матрцы!");
            }
        }

        row--;
        col--;

        if (col >= 0 && row >= 0){
            System.out.print("Строка " + (row + 1) + " :");
            for (int i = 0; i < matrix[row].length; i++){
                System.out.print(matrix[row][i] + " ");
            }

            System.out.println();

            System.out.print("Столбец " + (col + 1) + " :");
            for (int i = 0; i < matrix.length; i++){
                System.out.print(matrix[i][col] + " ");
            }
        }
    }
}
