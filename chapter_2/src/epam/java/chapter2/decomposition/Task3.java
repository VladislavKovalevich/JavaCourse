package epam.java.chapter2.decomposition;

/**
 * Вычислить площадь правильного шестиугольника со стороной а,
 * используя метод вычисления площади треугольника.
 */
public class Task3 {
    public static void main(String[] args) {
        int sideValue = 2;

        double figureArea;

        figureArea = 6 * getTriangleArea(sideValue);

        System.out.println(figureArea);
    }

    private static double getTriangleArea(int sideValue) {
        double areaValue;

        areaValue = (Math.sqrt(3) * (sideValue * sideValue)) / 4;

        return areaValue;
    }
}
