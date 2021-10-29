package epam.java.chapter2.decomposition;

/**
 * Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */
public class Task16 {
    public static void main(String[] args) {
        int n;
        int k;

        long sum;
        int countEvenNumbers;

        n = 3;
        k = 1;

        for (int i = 0; i < n; i++){
            k = k * 10;
        }

        sum = getOddSum(k);
        countEvenNumbers = getCountEvenNumbersInSum(sum);

        System.out.println("Сумма чисел с нечетными цифрами = " + sum);
        System.out.println("Количество четных цифр в сумме = " + countEvenNumbers);
    }

    private static int getCountEvenNumbersInSum(long sum) {
        int countEvenNumbers;

        countEvenNumbers = 0;

        while (sum > 0 ){

            long s = sum % 10;
            s = s % 2;

            if (s == 0){
                countEvenNumbers++;
            }

            sum = sum / 10;
        }

        return countEvenNumbers;
    }

    private static long getOddSum(int k) {
        long sum;

        sum = 0;

        for (long i = k / 10; i < k - 1; i++){

            if (isAllDigitOdd(i)){
                sum = sum + i;
            }
        }

        return sum;
    }

    private static boolean isAllDigitOdd(long i) {
        boolean flag;

        flag = true;

        while(i > 0 && flag){
            if ((i % 10) % 2 == 0){
                flag = false;
            }else{
                i = i / 10;
            }
        }

        return flag;
    }
}
