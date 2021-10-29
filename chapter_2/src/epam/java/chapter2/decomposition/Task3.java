package epam.java.chapter2.decomposition;

/**
 * Вычислить площадь правильного шестиугольника со стороной а,
 * используя метод вычисления площади треугольника.
 */
public class Task3 {
    public static void main(String[] args) {
        int sideValue;
        double figureSquare;

        sideValue = 4;
        figureSquare = getFigureSquare(sideValue);

        System.out.println(figureSquare);
    }

    private static double getTriangleSquare(int sideValue) {
        double areaValue;

        areaValue = (Math.sqrt(3) * (sideValue * sideValue)) / 4;

        return areaValue;
    }

    private static double getFigureSquare(int sideValue){
        double figureSquare;

        figureSquare = 6 * getTriangleSquare(sideValue);

        return figureSquare;
    }
}
