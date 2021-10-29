package epam.java.chapter2.matrix;

import java.util.Random;

/**
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму.
 */
public class Task9 {
    public static void main(String[] args) {
        int matrix[][];
        Random random;

        matrix = new int[4][4];
        random = new Random();

        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++){

                matrix[i][j] = random.nextInt(50) + 10;
                System.out.print(" "+ matrix[i][j] + " ");

            }

            System.out.println();
        }

        System.out.println();

        int maxSum;
        int index;

        maxSum = 0;
        index = 0;

        for (int i = 0; i < matrix[0].length; i++){

            int currSum;

            currSum = 0;

            for (int j = 0; j < matrix.length; j++){
                currSum += matrix[j][i];
            }

            System.out.println("Сумма в столбце №"+ (i + 1) + ": "+ currSum);

            if (currSum > maxSum){
                maxSum = currSum;
                index = i;
            }
        }

        System.out.println("\nМаксимальная сумма находиться в " +
                "столбце №" + (index + 1) + "\nЗначение суммы = " + maxSum);
    }
}
