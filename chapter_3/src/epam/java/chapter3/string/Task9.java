package epam.java.chapter3.string;

import java.util.Scanner;

/**
 * Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
 * буквы.
 */

public class Task9 {
    public static void main(String[] args) {
        String inputString;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println("Введите строку:");
        inputString = in.nextLine();

        countLowerAndUpperCase(inputString);
    }

    private static void countLowerAndUpperCase(String inputString) {
        int upperCaseCount;
        int lowerCaseCount;

        upperCaseCount = getCountOfUpperCaseSymbol(inputString);
        lowerCaseCount = getCountOfLowerCaseSymbol(inputString);

        System.out.println("Количество символов в верхнем регистре = "+ upperCaseCount);
        System.out.println("Количество символов в верхнем регистре = "+ lowerCaseCount);
    }

    private static int getCountOfLowerCaseSymbol(String inputString) {
        int count;
        char currentChar;

        count = 0;


        for (int i = 0; i < inputString.length(); i++) {
            currentChar = inputString.charAt(i);

            if (Character.isLowerCase(currentChar) &&
                    Character.UnicodeBlock.of(currentChar) != Character.UnicodeBlock.CYRILLIC){

                count++;
            }
        }

        return count;
    }

    private static int getCountOfUpperCaseSymbol(String inputString) {
        int count;
        char currentChar;

        count = 0;


        for (int i = 0; i < inputString.length(); i++) {
            currentChar = inputString.charAt(i);

            if (Character.isUpperCase(currentChar) &&
                    Character.UnicodeBlock.of(currentChar) != Character.UnicodeBlock.CYRILLIC){

                count++;
            }
        }

        return count;
    }
}
