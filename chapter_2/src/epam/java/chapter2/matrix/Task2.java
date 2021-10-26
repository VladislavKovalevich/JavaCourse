package epam.java.chapter2.matrix;

import java.util.Random;

/**
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */
public class Task2 {
    public static void main(String[] args) {
        int []  matrix[] = new int[5][5];

        Random r = new Random();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print("  "+matrix[i][j] + "  ");
            }

            System.out.println();
        }


        System.out.println();

        int [] mainDiagonal = new int[matrix.length],
               sideDiagonal = new int[matrix.length];

        int mainDiagonalCount = 0, sideDiagonalCount = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){

                if (i == j){
                    mainDiagonal[mainDiagonalCount++] = matrix[i][j];
                }

                if (i + j == matrix.length - 1){
                    sideDiagonal[sideDiagonalCount++] = matrix[i][j];
                }
            }
        }



        System.out.print("Главная диагональ: ");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(mainDiagonal[i] + " ");
        }

        System.out.println();

        System.out.print("Побочная диагональ: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(sideDiagonal[i] + " ");
        }

    }
}
