package epam.java.chapter2.matrix;

import java.util.Random;

/**
 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
public class Task1 {
    public static void main(String[] args) {
        int matrixSize;
        int matrix[][];
        Random r;

        matrixSize = 7;
        matrix = new int[matrixSize][matrixSize];
        r = new Random();

        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print(" "+ matrix[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < matrix.length; i++){

            if ((i + 1) % 2 != 0 && matrix[0][i] > matrix[matrix.length - 1][i])
            {
                System.out.print("столбец "+ (i+1) + " = " );

                for (int[] aMatrix : matrix) {
                    System.out.print(aMatrix[i] + " ");
                }

                System.out.println();
            }
        }
    }
}
