package epam.java.chapter2.decomposition;

/**
 * Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
 * решения задачи использовать декомпозицию.
 */
public class Task13 {
    public static void main(String[] args) {
        int n = 30;

        getTwinsNumbers(n);
    }

    private static void getTwinsNumbers(int n) {
        int[] array;
        int size;

        size = getArrayLength(n);
        array = fillArray(size, n);

        for (int i = 0; i < array.length - 2; i++){
            if (isPrimalValue(array[i]) && isPrimalValue(array[i + 2])){
                System.out.println("("+ array[i] + ", "+ array[i + 2] + ")");
            }
        }
    }

    private static boolean isPrimalValue(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static int getArrayLength(int n) {
        int length;

        length = 2*n - n + 1;

        return length;
    }

    private static int[] fillArray(int size, int n){
        int[] array;

        array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = n + i;
        }

        return array;
    }
}
