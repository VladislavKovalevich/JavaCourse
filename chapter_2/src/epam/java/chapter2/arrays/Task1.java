package epam.java.chapter2.arrays;

/**
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */
public class Task1 {
    public static void main(String[] args) {
        int K = 6;

        int[] A = {23, 36, 75, 34, 132, 76, 91, 81, 101};

        int sum = 0;

        for (int i = 0 ; i < A.length; i++){
            if (A[i] % K == 0){
                sum += A[i];
            }
        }

        System.out.println("Сумма = " + sum);
    }
}
