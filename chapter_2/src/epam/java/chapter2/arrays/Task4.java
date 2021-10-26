package epam.java.chapter2.arrays;

/**
 * Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */
public class Task4 {
    public static void main(String[] args) {
        double[] A = {-5.23, -5.132, -5.143, -5.13413, -5.14,
                -5.34, 1.9009, 0.131344};

        System.out.println("Исходная последовательность:");

        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");

        System.out.print("\n");


        double maxValue = -10000;
        int maxIndex = 0;

        double minValue = 100000;
        int minIndex = 0;

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

        System.out.println("Результирующая последовательность:");

        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
    }
}
