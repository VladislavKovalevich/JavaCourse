package epam.java.chapter2.matrix;

/**
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */
public class Task10 {
    public static void main(String[] args) {
        int matrix[][] = {{-3, -1, 2}, {2, -5, 3}, {0, 1, -5}};

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
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
