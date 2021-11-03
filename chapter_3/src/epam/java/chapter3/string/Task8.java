package epam.java.chapter3.string;

import java.util.Scanner;

/**
 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
 * длинных слов может быть несколько, не обрабатывать.
 */
public class Task8 {
    public static void main(String[] args) {
        String inputString;
        String longestWord;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println("Введите строку: ");
        inputString = in.nextLine();

        System.out.println(inputString);

        longestWord = getLongestWord(inputString);

        if (longestWord == null){
            System.out.println("Строка имеет несколько слов максимальной длинны");
        }else {
            System.out.println("Слово с максимальной длинной: " + longestWord);
        }
    }

    private static String getLongestWord(String inputString) {
        String[] stringArray;
        String finalString;
        int maxLengthString;

        finalString = null;
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