package epam.java.chapter3.string;

/**
 * Проверить, является ли заданное слово палиндромом.
 */
public class Task3 {
    public static void main(String[] args) {
        String s;
        boolean isPalindrome;

        s = "abcdcba";
        isPalindrome = checkPalindromeString(s);

        if (isPalindrome){
            System.out.println("Палиндром");
        }else {
            System.out.println("Не палиндром");
        }
    }

    private static boolean checkPalindromeString(String s) {
        int length;

        length = s.length();

        for (int i = 0; i < length / 2; i++) {

            if (s.charAt(i) != s.charAt(length - i - 1)){
                return false;
            }

        }

        return true;
    }
}
