package epam.java.chapter2.arrays;

/**
 * Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */
public class Task5 {
    public static void main(String[] args) {
        int[] A = {-1, 36, 75, -4, 3, -76, 91, 0, 1};

        System.out.println("Исходная последовательность:");

        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");

        System.out.print("\n");

        for (int i = 0 ; i < A.length; i++){
            if (A[i] > i){
                System.out.print(A[i] + " ");
            }
        }
    }
}
