package epam.java.chapter1.branching;

/**
 * Даны два угла треугольника (в градусах).
 * Определить, существует ли такой треугольник, и если да,
 * то будет ли он прямоугольным.
 */

public class Task1 {
    public static void main(String[] args) {
        double angle1 = 89.0;
        double angle2 = 90.0;

        if (angle1 + angle2 < 180.0){
            if (angle1 + angle2 == 90.0){
                System.out.println("Треугольник прямоугольный");
            }else {
                System.out.println("Треугольник не прямоугольный");
            }
        }else {
            System.out.println("Треугольник не существует");
        }
    }
}
