package epam.java.chapter2.matrix;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1 1 1 1...1
 * 2 2 2 2...0
 * 3 3 3 0...0
 * ...........
 * n-1 n-1...0
 * n 0 0 0...0
 */

public class Task5 {
    public static void main(String[] args) {
        int size;
        int matrix[][];

        size = 7;
        matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length - i; j++) {
                matrix[i][j] = i + 1;
            }

        }

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
