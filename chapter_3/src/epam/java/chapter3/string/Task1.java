package epam.java.chapter3.string;

/**
 * Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */
public class Task1 {
    public static void main(String[] args) {
        String string;

        string = "qwer       t  y";

        int maxCountSpaces = 0;

        maxCountSpaces = getMaxCountOfSpaces(string);

        System.out.println(maxCountSpaces);
    }

    private static int getMaxCountOfSpaces(String string) {
        int spaceCounts;
        int maxSpaceCounts;

        spaceCounts = 0;
        maxSpaceCounts = Integer.MIN_VALUE;

        for (int i = 0; i < string.length(); i++) {
            if (Character.isWhitespace(string.charAt(i))){
                spaceCounts++;
            }else {
                maxSpaceCounts = Math.max(maxSpaceCounts, spaceCounts);
                spaceCounts = 0;
            }
        }

        return maxSpaceCounts;

    }
}
