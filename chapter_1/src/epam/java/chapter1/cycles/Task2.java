package epam.java.chapter1.cycles;

import java.util.Scanner;

/**
 * Вычислить значения функции на отрезке [а,b] c шагом h
 */
public class Task2 {
    public static void main(String[] args) {
        double a;
        double b;
        double h;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число А:");
        a = sc.nextDouble();

        System.out.print("Введите число B:");
        b = sc.nextDouble();

        System.out.print("Введите шаг H:");
        h = sc.nextDouble();

        double sum = 0;

        for (double s = a; s <= b; s += h){
            if (s > 2.0){
                sum += s;
            }else {
                sum -= s;
            }
        }

        System.out.println("Результат = "+ sum);
    }
}
