package epam.java.chapter2.arrays;

/**
 * Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
 * числом. Подсчитать количество замен.
 */
public class Task2 {
    public static void main(String[] args) {
        int Z = 75;

        int[] A = {5, 36, 75, 4, 3, 76, 91, 0, 11};

        int changeCount = 0;

        System.out.println("Исходная последовательность:");
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");

        System.out.print("\n");

        for (int i = 0 ; i < A.length; i++){
            if (A[i] > Z){
                A[i] = Z;
                changeCount ++;
            }
        }

        System.out.println("Результирующая последовательность:");
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");

        System.out.print("\n");

        System.out.println("Количество замен = " + changeCount);
    }
}
