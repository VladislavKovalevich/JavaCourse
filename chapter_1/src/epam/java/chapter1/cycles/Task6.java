package epam.java.chapter1.cycles;

import java.util.Scanner;

/**
 * Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
 */
public class Task6 {
    public static void main(String[] args) {
        String exampleString;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println("Введите строку: ");
        exampleString = in.nextLine();

        System.out.println("Символ ---> Код");

        for (int i = 0; i < exampleString.length(); i++){
            System.out.println(exampleString.charAt(i) + " ---> " + (int)exampleString.charAt(i));
        }
    }
}
