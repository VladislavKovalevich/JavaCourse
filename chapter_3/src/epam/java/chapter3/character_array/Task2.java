package epam.java.chapter3.character_array;

/**
 * Замените в строке все вхождения 'word' на 'letter'. Примечание. Работа со строкой как с массивом символов
 */
public class Task2 {
    public static void main(String[] args) {
        String text;
        String word;
        String letter;

        text = "abc acd word word, ab word bbbb ccc word";
        word = "word";
        letter = "letter";

        text = replaceWords(text, word, letter);

        System.out.println(text);
    }

    private static String replaceWords(String text, String word, String letter) {

        while(text.contains(word)){
            text = text.
                    substring(0, text.indexOf(word)).
                    concat(letter).
                    concat(text.substring(text.indexOf(word) + word.length()));
        }

        return text;
    }
}
