package epam.java.chapter1.cycles;

/**
 * Вычислить значения функции на отрезке [а,b] c шагом h
 *  y = x, x > 2
 *  y = -x, x <= 2
 */
public class Task2 {
    public static void main(String[] args) {
        double a;
        double b;
        double h;

        double sum;

        a = 3.5;
        b = 4.2;
        h = 0.3;

        sum = 0;

        for (double s = a; s <= b; s += h){
            if (s > 2.0){
                sum += s;
            }else {
                sum -= s;
            }
        }

        System.out.println("Результат = " + sum);
    }
}
