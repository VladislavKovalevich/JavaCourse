package epam.java.chapter2.matrix;

import java.util.Arrays;
import java.util.Random;

/**
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */
public class Task2 {
    public static void main(String[] args) {
        int size;
        int matrix[][];

        Random r;

        size = 5;
        matrix = new int[size][size];

        r = new Random();

        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print("  "+matrix[i][j] + "  ");
            }

            System.out.println();
        }
        System.out.println();

        int [] mainDiagonal;
        int [] sideDiagonal;

        int mainDiagonalIndex;
        int sideDiagonalIndex;

        mainDiagonal = new int[size];
        sideDiagonal = new int[size];

        mainDiagonalIndex = 0;
        sideDiagonalIndex = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){

                if (i == j){
                    mainDiagonal[mainDiagonalIndex++] = matrix[i][j];
                }

                if (i + j == matrix.length - 1){
                    sideDiagonal[sideDiagonalIndex++] = matrix[i][j];
                }
            }
        }

        System.out.print("Главная диагональ: " + Arrays.toString(mainDiagonal));

        System.out.println();

        System.out.print("Побочная диагональ: " + Arrays.toString(sideDiagonal));
    }
}
