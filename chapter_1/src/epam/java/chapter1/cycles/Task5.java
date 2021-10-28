package epam.java.chapter1.cycles;

import java.util.Scanner;

/**
 * Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
 * заданному е. Общий член ряда имеет вид: An = 1/2^n + 1/3^n
 */
public class Task5 {
    public static void main(String[] args) {
        int e;

        Scanner sc;
        String message;

        double checkSum;
        double sum;

        int min;
        int max;

        sc = new Scanner(System.in);
        message = "ведите число e: ";

        System.out.print(message);

        while (!sc.hasNextInt()){
            sc.next();
            System.out.println(message);
        }

        e = sc.nextInt();

        sum = 0;
        min = -50;
        max = 50;

        for (int i = min; i < max; i++){
            checkSum = 1/Math.pow(2, i) + 1/Math.pow(3, i);
            if (Math.abs(checkSum) >= e){
                sum = sum + checkSum;
            }
        }

        System.out.println("Результат = " + sum);
    }
}
