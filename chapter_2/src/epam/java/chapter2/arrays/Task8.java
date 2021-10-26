package epam.java.chapter2.arrays;

/**
 * Дана последовательность целых чисел a1, a2, ..., an.
 * Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min( a1, a2, ..., an).
 */
public class Task8 {
    public static void main(String[] args) {
        int[] A = {-5, 36, -5, 4, -5, -5, 91, 9, -5, 1};

        int minValue = 10000;
        int minValueCount = 0;

        for (int i = 0; i < A.length; i++){
            if (A[i] < minValue)
                minValue = A[i];
        }

        for (int i = 0; i < A.length; i++){
            if (minValue == A[i]){
                minValueCount++;
            }
        }

        int[] B = new int[A.length - minValueCount];
        int j = 0;

        for (int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }

        System.out.print("\n");

        for (int i = 0; i < A.length; i++){
            if (A[i] != minValue){
                B[j] = A[i];
                j++;
            }
        }

        for (int i = 0; i < B.length; i++){
            System.out.print(B[i] + " ");
        }
    }
}
