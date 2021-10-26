package epam.java.chapter1.cycles;

import java.util.Scanner;

/**
 * Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
 * заданному е. Общий член ряда имеет вид: An = 1/2^n + 1/3^n
 */
public class Task5 {
    public static void main(String[] args) {
        double sum = 0;
        int e;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число E: ");
        e = sc.nextInt();

        double checkSum = 0;

        for (int i = -50; i < 50; i++){
            checkSum = 1/Math.pow(2, i) + 1/Math.pow(3, i);
            if (Math.abs(checkSum) >= e){
                sum = sum + checkSum;
            }
        }

        System.out.println("Результат = " + sum);
    }
}
