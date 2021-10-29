package epam.java.chapter2.arrays;

/**
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */
public class Task3 {
    public static void main(String[] args) {
        int negativeCounter;
        int positiveCounter;
        int zeroCounter;

        int[] A;

        A = new int[]{-5, 36, -75, 4, 3, 76, 91, 0, -12, 0};

        zeroCounter = 0;
        negativeCounter = 0;
        positiveCounter = 0;

        for (int element : A) {
            if (element == 0) {
                zeroCounter++;
            } else {
                if (element > 0) {
                    positiveCounter++;
                } else {
                    negativeCounter++;
                }
            }
        }

        System.out.println("Количество нулевых элементов = " + zeroCounter);
        System.out.println("Количество положительных элементов = " + positiveCounter);
        System.out.println("Количество отрицательных элементов = " + negativeCounter);

    }
}
