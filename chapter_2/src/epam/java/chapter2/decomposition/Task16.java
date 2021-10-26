package epam.java.chapter2.decomposition;

import java.math.BigInteger;

/**
 * Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */
public class Task16 {
    public static void main(String[] args) {
        int n = 3;
        int k = 1;

        for (int i = 0; i < n; i++){
            k = k * 10;
        }

        BigInteger sum;

        sum = getOddSum(k);

        int countEvenNumbers;

        countEvenNumbers = getCountEvenNumbers(sum);

        System.out.println("Sum = " + sum);

        System.out.println("Counter = " + countEvenNumbers);
    }

    private static int getCountEvenNumbers(BigInteger sum) {
        int countEvenNumbers = 0;

        while (sum.compareTo(BigInteger.valueOf(0)) > 0 ){

            BigInteger s = sum.mod(BigInteger.TEN);
            s = s.mod(BigInteger.valueOf(2));

            if (s.compareTo(BigInteger.ZERO) == 0){
                countEvenNumbers++;
            }

            sum = sum.divide(BigInteger.TEN);
        }

        return countEvenNumbers;
    }

    private static BigInteger getOddSum(int k) {
        BigInteger sum = BigInteger.ZERO;

        for (long i = k / 10; i < k - 1; i++){

            if (isAllOddNumbers(i)){
                sum = sum.add(BigInteger.valueOf(i));

            }
        }

        return sum;
    }

    private static boolean isAllOddNumbers(long i) {
        boolean flag = true;

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
