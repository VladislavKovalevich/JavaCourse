package epam.java.chapter2.decomposition;

/**
 *  Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */
public class Task11 {
    public static void main(String[] args) {
        int A = 1235;
        int B = 3215;

        String s = "";

        int countNumbersA = getCountNumbers(A);
        int countNumbersB = getCountNumbers(B);

        switch (getCmpResult(countNumbersA, countNumbersB)){
            case 0:{
                s = "Количество цифр одинаково";
                break;
            }
            case 1:{
                s = "Количество цифр в А больше чем в В";
                break;
            }
            case -1:{
                s = "Количество цифр в B больше чем в A";
                break;
            }
        }

        System.out.println(s);
    }

    private static int getCountNumbers(int number) {
        int counter = 0;

        while (number % 10 != 0){
            number = number / 10;
            counter++;
        }

        return counter;
    }

    private static int getCmpResult(int a, int b){
        if (a == b){
           return 0;
        }else{
            if (a > b){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
