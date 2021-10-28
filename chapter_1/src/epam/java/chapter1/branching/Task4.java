package epam.java.chapter1.branching;

/**
 * Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
 * отверстие.
 */

public class Task4 {
    public static void main(String[] args) {
        int A;
        int B;
        int x;
        int y;
        int z;

        A = 4;
        B = 5;

        x = 5;
        y = 5;
        z = 5;

        if ((x <= A && y <= B) || (y <= A && z <= B) ||
            (x <= A && z <= B) || (x <= B && y <= A) ||
            (y <= B && z <= A) || (x <= B && z <= A)){
            System.out.println("Результат = " + true);
        }else{
            System.out.println("Результат = " + false);
        }

    }
}
