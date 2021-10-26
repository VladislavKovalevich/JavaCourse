package epam.java.chapter3.string;

/**
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
 * def", то должно быть выведено "abcdef".
 */
public class Task7 {
    public static void main(String[] args) {
        String string;

        string = " abc cde def qwa zre fqx xwi tr";

        StringBuilder newString;

        newString = deleteSpacesAndRepeatedSymbols(string);

        System.out.println(newString);
    }

    private static StringBuilder deleteSpacesAndRepeatedSymbols(String string) {

        StringBuilder stringBuilder;

        stringBuilder = new StringBuilder(string.trim());

        for (int i = 0; i < stringBuilder.length(); i++) {

            for (int j = i + 1; j < stringBuilder.length(); j++) {

                if (stringBuilder.charAt(j) == stringBuilder.charAt(i) || Character.isWhitespace(stringBuilder.charAt(j)))
                {
                    stringBuilder.deleteCharAt(j);
                    j--;
                }

            }
        }

        return stringBuilder;
    }
}
