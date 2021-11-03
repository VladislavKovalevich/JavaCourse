package epam.java.chapter3.string;

/**
 * Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */
public class Task5 {
    public static void main(String[] args) {
        String string;
        int countA;

        string = "asdasdas dasd asfdfa eaefea feaasfaf asd af ";

        countA = getCountASymbol(string);

        System.out.println("Количество букв 'a' = "+ countA);
    }

    private static int getCountASymbol(String string) {
        int count;

        count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.indexOf('a', i) == i){
                count++;
            }
        }

        return count;
    }
}
