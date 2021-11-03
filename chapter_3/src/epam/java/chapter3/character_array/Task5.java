package epam.java.chapter3.character_array;

/**
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */
public class Task5 {
    public static void main(String[] args) {
        String string;
        string = "  abc   dcg  qweqw weq werqer qerer   erwer re ";

        System.out.print(deleteSpaces(string));

    }

    private static String deleteSpaces(String string) {
        String oneSpace;
        String doubleSpace;

        oneSpace = " ";
        doubleSpace = "  ";

        string = deleteFirstWhiteSpaces(string);
        string = deleteLastWhiteSpaces(string);

        while (string.contains(doubleSpace)){
            string = string.replace(doubleSpace, oneSpace);
        }

        return string;
    }

    private static String deleteLastWhiteSpaces(String string) {

        for (int i = string.length() - 1; i > 0; i--) {

            if (!Character.isWhitespace(string.charAt(i))){
                string = string.substring(0, i + 1);
                break;
            }

        }

        return string;
    }

    private static String deleteFirstWhiteSpaces(String string) {

        for (int i = 0; i < string.length(); i++) {

            if (!Character.isWhitespace(string.charAt(i))){
                string = string.substring(i);
                break;
            }

        }

        return string;
    }

}
