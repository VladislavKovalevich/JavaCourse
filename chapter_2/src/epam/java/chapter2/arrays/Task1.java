package epam.java.chapter2.arrays;

/**
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */
public class Task1 {
    public static void main(String[] args) {
        int K;
        int[] A;
        int sum;

        K = 6;
        A = new int[]{23, 36, 75, 34, 132, 76, 91, 81, 101};

        sum = 0;

        for (int element : A) {
            if (element % K == 0) {
                sum += element;
            }
        }

        System.out.println("Сумма элементов (кратных "+ K + ") = " + sum);
    }
}
