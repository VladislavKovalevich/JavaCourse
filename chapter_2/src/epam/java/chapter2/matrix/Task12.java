package epam.java.chapter2.matrix;

import java.util.Random;

/**
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */
public class Task12 {
    public static void main(String[] args) {
        int matrix [][] = new int[10][10];

        Random r = new Random();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = r.nextInt(60) + 10;

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();
        }


        for (int i = 0; i < matrix.length; i++) {
            boolean needIteration = true;
            int temp;
            while (needIteration) {
                needIteration = false;
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] > matrix[i][j - 1]) {
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i][j - 1];
                        matrix[i][j - 1] = temp;
                        needIteration = true;
                    }
                }
            }
        }

        System.out.println("\n\nСортировака строк по убыванию:\n");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean needIteration = true;
            int temp;
            while (needIteration) {
                needIteration = false;
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] < matrix[i][j - 1]) {
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i][j - 1];
                        matrix[i][j - 1] = temp;
                        needIteration = true;
                    }
                }
            }
        }

        System.out.println("\n\nСортировака строк по возрастанию:\n");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
