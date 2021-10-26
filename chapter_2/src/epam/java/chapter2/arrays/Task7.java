package epam.java.chapter2.arrays;

/**
 *  Даны действительные числа
 * a1, a2, ... , an. Найти max(a1 + a2n, a2 + a2n−1, ... , an + an+1).
 */
public class Task7 {
    public static void main(String[] args) {
        double[] A = {10.6, -5.0, 5.5, 7.1, 3.9, 15.5, 2.9, 1.9};

        double maxSum = -10000.0;
        double currSum;

        for (int i = 0; i < A.length / 2; i++){
            currSum = A[i] + A[A.length - i - 1];

            if (currSum > maxSum){
                maxSum = currSum;
            }
        }

        System.out.println(maxSum);
    }
}
