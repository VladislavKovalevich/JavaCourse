package epam.java.chapter2.decomposition;

/**
 * Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */
public class Task2 {
    public static void main(String[] args) {
        int a[];

        a = new int[]{27, 9, 81, 54};

        System.out.println(gcdNCount(a));
    }

    private static int gcdNCount(int[] values){
        int gcdValue;

        gcdValue = gcd(values[0], values[1]);

        for (int i = 2; i < values.length; i++) {
            gcdValue = gcd(gcdValue, values[i]);
        }

        return gcdValue;
    }

    private static int gcd(int a, int b){
        if (a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (a % b != 0) {
            a = a % b;
            int tmp = a;
            a = b;
            b = tmp;
        }

        return b;
    }
}
