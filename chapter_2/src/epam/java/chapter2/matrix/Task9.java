package epam.java.chapter2.matrix;

import java.util.Random;

/**
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму.
 */
public class Task9 {
    public static void main(String[] args) {
        int matrix[][] = new int[4][4];

        Random r = new Random();

        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++){

                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print(" "+ matrix[i][j] + " ");

            }

            System.out.println();
        }


        int maxSum = 0, index = 0;

        for (int i = 0; i < matrix[0].length; i++){

            int sum = 0;

            for (int j = 0; j < matrix.length; j++){
                sum += matrix[j][i];
            }

            if (sum > maxSum){
                maxSum = sum;
                index = i;
            }
        }

        System.out.println("\nМаксимальная сумма находиться в " +
                "столбце " + (index + 1) + "\nЗначение суммы = " + maxSum);
    }
}
