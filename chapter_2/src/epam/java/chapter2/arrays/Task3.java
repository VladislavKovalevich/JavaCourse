package epam.java.chapter2.arrays;

/**
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */
public class Task3 {
    public static void main(String[] args) {
        int negativeCounter = 0;
        int positiveCounter = 0;
        int zeroCounter = 0;

        int[] A = {-5, 36, -75, 4, 3, 76, 91, 0, -12, 0};

        for (int i = 0; i < A.length; i++){
            if (A[i] == 0){
                zeroCounter++;
            }else{
                if (A[i] > 0){
                    positiveCounter++;
                }else{
                    negativeCounter++;
                }
            }
        }

        System.out.println("Количество нулевых элементов = " + zeroCounter);
        System.out.println("Количество положительных элементов = " + positiveCounter);
        System.out.println("Количество отрицательных элементов = " + negativeCounter);

    }
}
