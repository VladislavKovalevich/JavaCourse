package epam.java.chapter3.character_array;

/**
 * В строке найти количество чисел.
 */

public class Task4 {
    public static void main(String[] args) {
        String string;

        string = "q1 1132werew 24 weqwew31,32 wq ewe q223 qw2";

        int countOfNumbers;

        countOfNumbers = getCountOfNumber(string);

        System.out.println("Количество цифр = "+ countOfNumbers);
    }

    private static int getCountOfNumber(String string) {
        int counter;

        counter = 0;

        for (int i = 0; i < string.length(); i++) {

            if (Character.isDigit(string.charAt(i))) {

                if ((i + 1) < string.length()) {

                    if (!Character.isDigit(string.charAt(i + 1)) || i == string.length() - 1) {
                        counter++;
                    }

                }else {
                    counter++;
                }

            }

        }

        return counter;
    }
}