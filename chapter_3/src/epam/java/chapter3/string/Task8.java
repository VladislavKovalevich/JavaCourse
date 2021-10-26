package epam.java.chapter3.string;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
 * длинных слов может быть несколько, не обрабатывать.
 */
public class Task8 {
    public static void main(String[] args) {
        String inputString = "";

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите строку:");

            inputString = scanner.nextLine();
        }catch (InputMismatchException ex){
            System.out.println("Ошибка ввода");
        }

        System.out.println(inputString);

        String longestWord;

        longestWord = getLongestWord(inputString);


        if (longestWord == null){
            System.out.println("Строка имеет несколько слов максимальной длинны");
        }else {
            System.out.println("Слово с максимальной длинной: " + longestWord);
        }
    }

    private static String getLongestWord(String inputString) {
        String[] stringArray;
        String finalString = null;

        int maxLengthString;

        maxLengthString = Integer.MIN_VALUE;

        stringArray = inputString.split(" ");

        for (int i = 0; i < stringArray.length; i++) {

            if (maxLengthString < stringArray[i].length()){

                maxLengthString = stringArray[i].length();
                finalString = stringArray[i];

            }else if (maxLengthString == stringArray[i].length()){

                finalString = null;
            }
        }

        return finalString;
    }
}