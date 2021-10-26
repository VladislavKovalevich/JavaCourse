package epam.java.chapter3.character_array;

/**
 *  В строке найти количество цифр.
 */
public class Task3 {
    public static void main(String[] args) {
        String string;
        string = "qwe wq qr 1 1132werew 24 weqwew31 wq ewe q2";

        int digitsCounter;

        digitsCounter = getDigitsCount(string);

        System.out.println("Количество цифр = "+ digitsCounter);
    }

    private static int getDigitsCount(String string) {
        int count = 0;
        char currChar;

        for (int i = 0; i < string.length(); i++) {

            currChar = string.charAt(i);

            if (Character.isDigit(currChar)){
                count++;
            }

        }

        return  count;
    }
}
