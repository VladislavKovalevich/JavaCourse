package epam.java.chapter2.matrix;

import java.util.Random;

/**
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
 * которых число 5 встречается три и более раз.
 */
public class Task11 {

    public static void main(String[] args) {
        int matrix [][];
        Random r;

        matrix = new int[10][20];
        r = new Random();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = r.nextInt(16);

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();
        }


        System.out.print("\nСтроки: ");

        for (int i = 0; i < matrix.length; i++) {

            int count;
            count = 0;

            for (int j = 0; j < matrix[i].length; j++) {

                if(matrix[i][j] == 5){
                   count++;
                }

            }

            if (count >= 3){
                System.out.print(i + "; ");
            }
        }
    }
}
