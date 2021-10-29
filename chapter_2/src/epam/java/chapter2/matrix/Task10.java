package epam.java.chapter2.matrix;

import java.util.Arrays;

/**
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */
public class Task10 {
    public static void main(String[] args) {
        int matrix[][];

        matrix = new int[][]{{3, -1, 2}, {2, 5, 3}, {0, 1, -5}};

        for (int[] aMatrix : matrix) {
            System.out.println(Arrays.toString(aMatrix));
        }


        System.out.print("\nПоложительные элементы главной диагонали:");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (i == j && matrix[i][j] >= 0)
                {
                    System.out.print(" " + matrix[i][j]);
                }
            }
        }

    }
}
