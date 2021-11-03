package epam.java.chapter3.string;

/**
 * Из заданной строки получить новую, повторив каждый символ дважды.
 */
public class Task6 {
    public static void main(String[] args){
        String string;
        StringBuilder finalString;

        string = "abcdefghigklmnopqrstuvwxyz";

        finalString = getDoubleCharsString(string);

        System.out.println(finalString.toString());
    }

    private static StringBuilder getDoubleCharsString(String string) {
        StringBuilder stringBuilder;
        char currSymbol;

        stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            currSymbol = string.charAt(i);
            stringBuilder.append(currSymbol).append(currSymbol);

        }

        return stringBuilder;
    }
}
