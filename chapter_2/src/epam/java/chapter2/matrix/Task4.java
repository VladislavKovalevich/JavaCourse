package epam.java.chapter2.matrix;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1 2   .. n
 * n n-1 .. 1
 * 1 2   .. n
 * n n-1 .. 1
 * 1 2   .. n
 */

public class Task4 {
    public static void main(String[] args) {
        int size;
        int matrix[][];

        size = 6;
        matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length ; j++) {

                matrix[i][j] = i % 2 == 0 ? (j + 1) : matrix[i].length - j;
                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();
        }
    }
}
