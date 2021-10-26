package epam.java.chapter4.task7.action;

import epam.java.chapter4.task7.entity.Point;
import epam.java.chapter4.task7.entity.Triangle;

public class TriangleAction {

    public TriangleAction(){

    }

    public double getPerimeter(Triangle triangle){
        double perimeter;

        perimeter = triangle.getA().getLength() + triangle.getB().getLength() + triangle.getC().getLength();

        return perimeter;
    }

    public double getSquare(Triangle triangle){

        double halfPerimeter;
        double s;

        halfPerimeter = getPerimeter(triangle) / 2;

        s = Math.sqrt(halfPerimeter * (halfPerimeter - triangle.getA().getLength()) * (halfPerimeter - triangle.getB().getLength()) * (halfPerimeter - triangle.getC().getLength()));

        return s;
    }

    public Point getCentroid(Triangle triangle){

        double x;
        double y;
        Point intersection;

        x = (triangle.getA().getBegin().getX() + triangle.getB().getBegin().getX() + triangle.getC().getBegin().getX()) / 3;
        y = (triangle.getA().getBegin().getY() + triangle.getB().getBegin().getY() + triangle.getC().getBegin().getY()) / 3;

        intersection = new Point(x, y);

        return intersection;
    }
}
