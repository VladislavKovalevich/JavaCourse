package epam.java.chapter2.decomposition;

/**
 * Написать метод(методы) для нахождения наибольшего общего делителя и
 * наименьшего общего кратного двух натуральных чисел.
 */
public class Task1 {
    public static void main(String[] args) {
        int a = 22;
        int b = 44;

        System.out.println("НОК = " + lcm(a, b));
        System.out.println("НОД = " + gcd(a, b));
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

    private static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }
}
