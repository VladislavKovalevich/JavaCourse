package epam.java.chapter2.arrays;

/**
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
 * являются простыми числами.
 */
public class Task6 {
    public static void main(String[] args) {
        double[] A = {-1.0, -5.0, 5.5, 7.1, 3.9, -5.5, 2.9, 0.9};

        double sum = 0;
        boolean isPrimalIndex;

        for (int i = 0; i < A.length; i++) {

            isPrimalIndex = false;

            if (i < 2) {
                isPrimalIndex = true;
            } else  {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrimalIndex = true;
                        break;
                    }
                }
            }

            if (!isPrimalIndex){
                sum += A[i];
            }
        }

        System.out.println("Сумма = "+ sum);
    }
}
