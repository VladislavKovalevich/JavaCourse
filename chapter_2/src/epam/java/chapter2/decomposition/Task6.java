package epam.java.chapter2.decomposition;

/**
 * Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
 */
public class Task6 {
    public static void main(String[] args) {
        int a;
        int b;
        int c;

        a = 6;
        b = 81;
        c = 9;

        if (isCoprimeNumbers(a, b, c)){
            System.out.println("Данные числа взаимно простые");
        }else {
            System.out.println("Данные числа не взаимно простые");
        }
    }

    private static boolean isCoprimeNumbers(int a, int b, int c) {
        int gcdValue;

        gcdValue = gcd(a, b);
        gcdValue = gcd(gcdValue, c);

        return (gcdValue == 1);
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
