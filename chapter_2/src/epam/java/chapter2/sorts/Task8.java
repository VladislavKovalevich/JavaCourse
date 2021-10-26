package epam.java.chapter2.sorts;

import java.util.Random;

class Fraction{
    private int number;
    private int denom;

    Fraction(int number, int denom){
        this.denom = denom;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }
}

/**
 * Даны дроби p1/q1, p2/q2, ..., pn/qn (pi, qi - натуральные).
 * Составить программу, которая приводит эти дроби к общему
 * знаменателю и упорядочивает их в порядке возрастания.
 */
public class Task8 {
    public static void main(String[] args) {
        int N = 5;
        Fraction[] arrayFraction = new Fraction[N];

        Random r = new Random();

        int number;
        int denom;

        for (int i = 0; i < arrayFraction.length; i++) {
            number = r.nextInt(20) + 3;
            denom = r.nextInt(20) + 3;
            arrayFraction[i] = new Fraction(number, denom);
        }

        int lcm_value = 0;

        int gcd = 0;
        int a = arrayFraction[0].getDenom();
        int b = arrayFraction[1].getDenom();

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

        lcm_value = (arrayFraction[0].getDenom()*arrayFraction[1].getDenom())/gcd;

        for (int i = 2; i < arrayFraction.length; i++) {
            a = lcm_value;
            b = arrayFraction[i].getDenom();

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

            lcm_value = (lcm_value*arrayFraction[i].getDenom())/gcd;
        }


        for (Fraction f : arrayFraction) {
            System.out.print(f.getNumber() + "/" + f.getDenom() + "  ");
        }


        int tempMul = 1;

        // приведение к одному знаменателю
        for (int i = 0; i < arrayFraction.length; i++) {

            tempMul = lcm_value / arrayFraction[i].getDenom();

            int numberFr = arrayFraction[i].getNumber();

            arrayFraction[i].setNumber(tempMul* numberFr);
            arrayFraction[i].setDenom(lcm_value);
        }

        System.out.println();

        for (Fraction f : arrayFraction) {
            System.out.print(f.getNumber() + "/" + f.getDenom() + "  ");
        }

        // сортировка дробей
        for (int i = 0; i < arrayFraction.length - 1;) {

            if (arrayFraction[i].getNumber() > arrayFraction[i + 1].getNumber()){

                int tempSort = arrayFraction[i].getNumber();
                arrayFraction[i].setNumber(arrayFraction[i + 1].getNumber());
                arrayFraction[i + 1].setNumber(tempSort);

                if (i != 0) {
                    i--;
                }
            }else if (i != arrayFraction.length - 1){
                i++;
            }

        }

        System.out.println();

        for (Fraction f : arrayFraction) {
            System.out.print(f.getNumber() + "/" + f.getDenom() + "  ");
        }
    }
}


