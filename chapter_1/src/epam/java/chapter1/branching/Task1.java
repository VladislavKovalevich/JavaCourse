package epam.java.chapter1.branching;

/**
 * Даны два угла треугольника (в градусах).
 * Определить, существует ли такой треугольник, и если да,
 * то будет ли он прямоугольным.
 */

public class Task1 {
    public static void main(String[] args) {
        double angle1;
        double angle2;

        angle1 = 90.0;
        angle2 = 20.0;

        if (angle1 + angle2 < 180.0){
            if ((angle1 + angle2 == 90.0) || (angle1 == 90) || (angle2 == 90)){
                System.out.println("Треугольник прямоугольный");
            }else {
                System.out.println("Треугольник не прямоугольный");
            }
        }else {
            System.out.println("Треугольник не существует");
        }
    }
}
