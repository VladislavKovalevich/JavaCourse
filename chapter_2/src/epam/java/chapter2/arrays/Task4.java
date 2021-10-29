package epam.java.chapter2.arrays;

import java.util.Arrays;

/**
 * Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */
public class Task4 {
    public static void main(String[] args) {
        double[] A;

        double maxValue;
        double minValue;

        int maxIndex;
        int minIndex;

        A = new double[] {-5.23, -5.132, -5.143, -5.13413, -5.14, -5.34, 1.9009, 0.131344};

        System.out.println("Исходная последовательность:\n"+ Arrays.toString(A) +"\n");

        maxValue = Double.MIN_VALUE;
        maxIndex = 0;

        minValue = Double.MAX_VALUE;
        minIndex = 0;

        for (int i = 0; i < A.length; i++){
            if (maxValue < A[i]){
                maxValue = A[i];
                maxIndex = i;
            }

            if (minValue > A[i]){
                minValue = A[i];
                minIndex = i;
            }
        }

        A[minIndex] = maxValue;
        A[maxIndex] = minValue;

        System.out.println("Результирующая последовательность:\n"+ Arrays.toString(A) +"\n");
    }
}
