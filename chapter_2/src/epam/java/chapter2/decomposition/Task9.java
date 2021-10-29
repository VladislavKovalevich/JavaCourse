package epam.java.chapter2.decomposition;

/**
 * Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
 * если угол между сторонами длиной X и Y— прямой.
 */
public class Task9 {
    public static void main(String[] args) {
        int X;
        int Y;
        int Z;
        int T;

        double area;

        X = 3;
        Y = 4;
        Z = 7;
        T = 11;

        area = getAreaValue(X, Y, Z, T);

        System.out.println("Площадь фигуры = "+ area);
    }

    private static double getAreaValue(int x, int y, int z, int t) {
        double area;
        double hypotenuse;

        hypotenuse = getHypotenuseValue(x, y);
        area = getRectangularTriangleArea(x, y) + getRandomTriangleArea(hypotenuse, z, t);

        return area;
    }

    private static double getRandomTriangleArea(double hypotenuse, int z, int t) {
        double p;

        p = getHalfPerimeter(hypotenuse, z, t);

        return Math.sqrt(p*(p - hypotenuse) * (p - z) * (p - t));
    }

    private static double getHalfPerimeter(double hypotenuse, int z, int t) {
        return (hypotenuse + z + t) / 2.0;
    }


    private static double getRectangularTriangleArea(int x, int y) {
        return (double)(x*y) / 2.0;
    }

    private static double getHypotenuseValue(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }
}
