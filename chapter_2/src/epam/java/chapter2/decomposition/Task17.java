package epam.java.chapter2.decomposition;

/**
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
 * действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 */
public class Task17 {
    public static void main(String[] args) {
        int value = 86;

        int countOfIteration = getCountOfIteration(value);

        System.out.println("Количество итераций = "+ countOfIteration);
    }

    private static int getCountOfIteration(int value) {
        int count = 0;
        int sumNumbers;

        while(value != 0){
            sumNumbers = getSumOfNumbers(value);

            System.out.println(value + ", " + sumNumbers);

            value = value - sumNumbers;
            count++;
        }

        return count;
    }

    private static int getSumOfNumbers(int value) {
        int s = 0;

        while (value != 0){
            s = s + value % 10;
            value = value / 10;
        }

        return s;
    }
}
