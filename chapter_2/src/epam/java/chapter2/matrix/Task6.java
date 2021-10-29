package epam.java.chapter2.matrix;

import java.util.Arrays;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1 1 1...1 1 1
 * 0 1 1...1 1 0
 * 0 0 1...1 0 0
 * .............
 * 0 1 1...1 1 0
 * 1 1 1...1 1 1
 */
public class Task6 {
    public static void main(String[] args) {
        int size;
        int matrix[][];

        int flag;

        size = 8;
        matrix = new int[size][size];


        for (int i = 0; i < matrix.length; i++) {

            if (i >= matrix.length / 2){
                flag = matrix.length - i - 1;
            }else{
                flag = i;
            }

            for (int j = flag; j < matrix[i].length - flag; j++) {
                matrix[i][j] = 1;
            }
        }

        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}
