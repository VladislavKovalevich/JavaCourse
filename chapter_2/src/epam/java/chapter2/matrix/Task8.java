package epam.java.chapter2.matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.
 */
public class Task8 {
    public static void main(String[] args) {
        int matrix[][];
        Random r;
        Scanner in;

        matrix = new int[7][5];
        r = new Random();
        in = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt(50) + 10;
                System.out.print(" "+ matrix[i][j] + " ");
            }

            System.out.println();
        }

        int indexColSrc;
        int indexColDest;

        while (true) {
            int curr;

            System.out.print("Введите номер первого столбца: ");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("Введите номер первого столбца: ");
            }

            curr = in.nextInt();

            if (curr < matrix[0].length){
                indexColSrc = curr;
                break;
            }else {
                System.out.println("Вход за пределы матрцы!");
            }
        }

        while (true) {
            int curr;

            System.out.print("Введите номер второго столбца: ");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("Введите номер второго столбца: ");
            }

            curr = in.nextInt();

            if (curr < matrix[0].length && curr != indexColSrc){
                indexColDest = curr;
                break;
            }else {
                System.out.println("Вход за пределы матрцы!");
            }
        }

        int temp;

        for (int i = 0; i < matrix.length; i++){
            temp = matrix[i][indexColSrc];
            matrix[i][indexColSrc] = matrix[i][indexColDest];
            matrix[i][indexColDest] = temp;
        }

        System.out.println();

        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(" " + anAMatrix + " ");
            }
            System.out.println();
        }
    }
}
