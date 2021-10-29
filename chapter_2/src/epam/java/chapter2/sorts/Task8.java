package epam.java.chapter2.sorts;

import java.util.Random;
/**
 * Даны дроби p1/q1, p2/q2, ..., pn/qn (pi, qi - натуральные).
 * Составить программу, которая приводит эти дроби к общему
 * знаменателю и упорядочивает их в порядке возрастания.
 */
public class Task8 {
    public static void main(String[] args) {
        int N;
        int arrayFraction[][];
        Random r;

        N = 5;
        r = new Random();
        arrayFraction = new int[N][2];

        for (int i = 0; i < arrayFraction.length; i++) {
            arrayFraction[i][0] = r.nextInt(20) + 3;
            arrayFraction[i][1] = r.nextInt(20) + 3;
        }

        int lcm_value;
        int gcd;
        int a;
        int b;

        a = arrayFraction[0][1];
        b = arrayFraction[1][1];

        if (a < b) {
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

        gcd = b;
        lcm_value = (arrayFraction[0][1] * arrayFraction[1][1]) / gcd;

        for (int i = 2; i < arrayFraction.length; i++) {
            a = lcm_value;
            b = arrayFraction[i][1];

            if (a < b) {
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

            gcd = b;

            lcm_value = (lcm_value * arrayFraction[i][1]) / gcd;
        }

        System.out.println("Начальное значение дробей: ");
        for (int[] fraction : arrayFraction) {
            System.out.print(fraction[0] + "/" + fraction[1] + "  ");
        }

        int tempMul;

        // приведение к одному знаменателю
        for (int i = 0; i < arrayFraction.length; i++) {

            tempMul = lcm_value / arrayFraction[i][1];

            int numberFr = arrayFraction[i][0];

            arrayFraction[i][0] = tempMul * numberFr;
            arrayFraction[i][1] = lcm_value;
        }

        System.out.println();

        System.out.println("Дроби, приведенные к общему знаменателю: ");
        for (int[] fraction : arrayFraction) {
            System.out.print(fraction[0] + "/" + fraction[1] + "  ");
        }

        // сортировка дробей
        for (int i = 0; i < arrayFraction.length - 1;) {

            if (arrayFraction[i][0] > arrayFraction[i + 1][0]){

                int tempSort = arrayFraction[i][0];
                arrayFraction[i][0] = arrayFraction[i + 1][0];
                arrayFraction[i + 1][0] = tempSort;

                if (i != 0) {
                    i--;
                }
            }else if (i != arrayFraction.length - 1){
                i++;
            }

        }

        System.out.println();
        System.out.println("Дроби упорядоченные по возврастанию: ");

        for (int[] fraction : arrayFraction) {
            System.out.print(fraction[0] + "/" + fraction[1] + "  ");
        }
    }
}