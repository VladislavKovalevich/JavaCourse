package epam.java.chapter2.decomposition;

/**
 *  Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */
public class Task11 {
    public static void main(String[] args) {
        int A;
        int B;

        int countNumbersA;
        int countNumbersB;

        A = 1235;
        B = 321556;

        countNumbersA = getCountNumbers(A);
        countNumbersB = getCountNumbers(B);

        System.out.println(cmpResult(countNumbersA, countNumbersB));
    }

    private static String cmpResult(int countNumbersA, int countNumbersB) {
        String res;

        res = "";

        switch (getCmpResult(countNumbersA, countNumbersB)){
            case 0:{
                res = "Количество цифр одинаково";
                break;
            }
            case 1:{
                res = "Количество цифр в А больше чем в В";
                break;
            }
            case -1:{
                res = "Количество цифр в B больше чем в A";
                break;
            }
        }
        return res;
    }

    private static int getCountNumbers(int number) {
        int counter;

        counter = 0;

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
