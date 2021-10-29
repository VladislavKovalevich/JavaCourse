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
                printFactorial(getFactorialValue(i), i);
            }
        }
    }

    private static int getFactorialValue(int i) {
        int result;

        result = 1;

        for (int j = 1; j <= i; j++) {
            result *= j;
        }

        return result;
    }

    private static void printFactorial(int value, int number){
        System.out.println(number + "! = " + value);
    }
}
