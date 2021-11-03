package epam.java.chapter4.task7;

import epam.java.chapter4.task7.action.TriangleAction;
import epam.java.chapter4.task7.entity.Point;
import epam.java.chapter4.task7.entity.Triangle;

/**
 * Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
 * площади, периметра и точки пересечения медиан.
 */
public class Main {
    public static void main(String[] args) {
        Triangle triangle;
        TriangleAction triangleAction;
        Point centroidPoint;

        triangle = new Triangle(
                new Point(0.0, 0.2),
                new Point(5.0, 10.1),
                new Point(0.0, 9.0)
        );

        triangleAction = new TriangleAction();

        System.out.println("Периметр треугольника = " + triangleAction.getPerimeter(triangle));
        System.out.println("Площадь треугольника = " + triangleAction.getSquare(triangle));

        centroidPoint = triangleAction.getCentroid(triangle);

        System.out.println("Точка пересечения медиан = " + centroidPoint.getX() + ", "+ centroidPoint.getY());
    }
}
