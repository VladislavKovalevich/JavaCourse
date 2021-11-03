package epam.java.chapter3.string;

import java.util.Scanner;

/**
 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 * знаком. Определить количество предложений в строке X.
 */
public class Task10 {
    public static void main(String[] args) {
        String inputString;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println("Введите строку:");
        inputString = in.nextLine();

        System.out.println("Количество предложений = "+getCountOfSentence(inputString));
    }

    private static int getCountOfSentence(String inputString) {
        char currentChar;
        int sentenceCount;
        String punctuationChars;

        sentenceCount = 0;
        punctuationChars = ".?!";

        for (int i = 0; i < inputString.length(); i++) {

            currentChar = inputString.charAt(i);

            if (punctuationChars.indexOf(currentChar) > -1){
                sentenceCount++;
            }

        }

        return sentenceCount;
    }
}
