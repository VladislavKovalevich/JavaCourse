package epam.java.chapter2.matrix;

/**
 * Сформировать квадратную матрицу порядка N по правилу:
 * A[I,J] = sin ((I*I - J*J)/ N);
 * и подсчитать количество положительных элементов в ней.
 */
public class Task7 {
    public static void main(String[] args) {
        int size;
        int positiveMatrixItemCount;
        double[] matrix[];

        size = 4;
        matrix = new double[size][size];

        positiveMatrixItemCount = 0;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = Math.sin((i*i - j*j)/8.0);

                System.out.print(matrix[i][j] + " ");

                if (matrix[i][j] > 0){
                    positiveMatrixItemCount++;
                }
            }

            System.out.println();
        }

        System.out.println();

        System.out.println("Количество положительных элементов " +
                "матрицы = "+ positiveMatrixItemCount);

    }
}
