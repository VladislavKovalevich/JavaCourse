package epam.java.chapter1.branching;

/**
 * Найти max{min(a, b), min(c, d)}
 */
public class Task2 {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int d;

        int minAB;
        int minCD;

        a = 10;
        b = 11;
        c = 9;
        d = 10;

        if (a <= b){
            minAB = a;
        }else
            minAB = b;

        if (c <= d){
            minCD = c;
        }else
            minCD = d;

        if (minAB > minCD){
            System.out.println("результат = " + minAB);
        }else
            System.out.println("результат = "+ minCD);

    }
}
