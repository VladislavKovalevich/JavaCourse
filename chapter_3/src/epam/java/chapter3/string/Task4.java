package epam.java.chapter3.string;

/**
 * С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */
public class Task4 {
    public static void main(String[] args) {
        String s;
        String resultString;

        s = "информатика";
        resultString = "";

        resultString = resultString.concat(s.substring(7, 8));
        resultString = resultString.concat(s.substring(3, 5));
        resultString = resultString.concat(s.substring(7, 8));

        System.out.println(resultString);
    }
}
