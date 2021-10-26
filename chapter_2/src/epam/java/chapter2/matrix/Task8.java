package epam.java.chapter2.matrix;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.
 */
public class Task8 {
    public static void main(String[] args) {

        int matrix[][] = new int[7][5];

        Random r = new Random();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print(" "+ matrix[i][j] + " ");
            }

            System.out.println();
        }

        int indexColSrc, indexColDest;

        try (Scanner in = new Scanner(System.in)) {

            System.out.print("Введите номер столбца: ");
            indexColSrc = in.nextInt();

            System.out.print("Введите номер строки: ");
            indexColDest = in.nextInt();

            if (indexColDest >= 0 && indexColSrc >= 0){
                int temp;

                for (int i = 0; i < matrix.length; i++){
                    temp = matrix[i][indexColSrc];
                    matrix[i][indexColSrc] = matrix[i][indexColDest];
                    matrix[i][indexColDest] = temp;
                }

            }

        } catch (InputMismatchException ex) {
            System.out.println("ошибка ввода");
        }

        System.out.println();

        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }
}
