package epam.java.chapter2.sorts;

/**
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив.
 */
public class Task1 {
    public static void main(String[] args) {
        int k = 5;

        int[] arraySrc = {2, 3, 5, 4, 6, 11, 34, 12};
        int[] arrayDest = {7, 5, 5, 5, 7};

        int[] summaryArray = new int[arrayDest.length + arraySrc.length];

        System.arraycopy(arraySrc, 0, summaryArray, 0, k);
        System.arraycopy(arrayDest, 0, summaryArray, k, arrayDest.length);
        System.arraycopy(arraySrc, k, summaryArray, k + arrayDest.length, arraySrc.length - k);

        for (int i = 0; i < summaryArray.length; i++) {
            System.out.print(summaryArray[i] + " ");
        }
    }
}
