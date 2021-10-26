package epam.java.chapter2.decomposition;

/**
 * Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */
public class Task7 {
    public static void main(String[] args) {
        getFactorialValueFromOddItems();
    }

    private static void getFactorialValueFromOddItems() {
        for (int i = 1; i < 10; i++) {
            if (i % 2 != 0){
                System.out.println(i+"! = "+getFactorialValue(i));
            }
        }
    }

    private static int getFactorialValue(int i) {
        int result = 1;

        for (int j = 0; j < i; j++) {
            result *= i;
        }

        return result;
    }
}
