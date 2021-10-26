package epam.java.chapter3.string;

/**
 * В строке вставить после каждого символа 'a' символ 'b'.
 */
public class Task2 {
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("ad ad acv cav ars rsa");

        System.out.println(insertBSymbol(string));
    }

    private static StringBuilder insertBSymbol(StringBuilder string) {
        int length = string.length();

        int i = 0;

        while (i < length) {

            if (string.indexOf("a", i) == i){

                string.insert(i + 1,'b');

                i++;
                length++;
            }

            i++;
        }

        return string;
    }
}
