package epam.java.chapter2.decomposition;

/**
 * Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */
public class Task15 {
    public static void main(String[] args) {
        int n;

        n = 4;

        nextNumber(0,0, 0, n - 1);
    }

    private static void nextNumber(int number, long num, int count, int n) {
        long s;

        if (number < 9){

            for (int i = number + 1; i <= 9; i++) {
                s = num * 10 + i;

                if (count == n) {
                    System.out.println(s);
                }

                nextNumber(i, s, count + 1, n);
            }
        }

    }


}
