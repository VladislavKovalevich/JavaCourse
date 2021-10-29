package epam.java.chapter2.decomposition;


/**
 * Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
 * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
 * использовать декомпозицию.
 */
public class Task14 {
    public static void main(String[] args) {
        int k = 500;

        getArmstrongNumbers(k);
    }

    private static void getArmstrongNumbers(int k) {
        for (int i = 1; i < k; i++) {
            if (isArmstrongNumber(i)){
                System.out.println(i + "; ");
            }
        }
    }

    private static boolean isArmstrongNumber(int i) {
        return getNumberValue(i) == i;
    }

    private static int getCountNumber(int i){
        int counter = 0;

        while (i != 0){
            counter++;
            i = i / 10;
        }

        return counter;
    }

    private static int getNumberValue(int i) {
        int sum = 0;
        int counter = getCountNumber(i);


        while (i != 0){
            sum += Math.pow(i % 10,counter);
            i = i / 10;
        }

        return sum;
    }
}
