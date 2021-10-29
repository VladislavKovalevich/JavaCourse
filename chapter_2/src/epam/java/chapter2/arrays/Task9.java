package epam.java.chapter2.arrays;

/**
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */
public class Task9 {
    public static void main(String[] args) {
        int[] A;
        int[] countArray;

        int maxCount;
        int index;

        A = new int[]{-5, 36, -5, -9, -5, -9, 91, -9, 4, -5};
        countArray = new int[A.length];

        for (int i = 0; i < countArray.length; i++){
            for (int item : A) {
                if (A[i] == item) {
                    countArray[i]++;
                }
            }
        }

        maxCount = 0;
        index = 0;

        for (int i = 0; i < A.length; i++){
            if (countArray[i] == maxCount){
                if (A[i] < A[index]){
                    index = i;
                }
            }else {
                if (countArray[i] > maxCount) {
                    maxCount = countArray[i];
                    index = i;
                }
            }
        }

        System.out.println("Значение: " + A[index] + "; Количество: " + maxCount);
    }
}
