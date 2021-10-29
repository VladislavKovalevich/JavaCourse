package epam.java.chapter2.decomposition;

/**
 * На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
 * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */
public class Task4 {
    public static void main(String[] args) {
        int[] xCoords;
        int[] yCoords;
        double maxLength;

        xCoords = new int[]{2, 3, 4, 31, 29};
        yCoords = new int[]{0, -1, -21, 15, 31};

        maxLength = getMaxLength(xCoords, yCoords);

        System.out.println(maxLength);
    }

    private static double getMaxLength(int[] xCoords, int[] yCoords) {
        double maxLength;
        double currentLength;

        maxLength = 0;

        for (int i = 0; i < xCoords.length - 1; i++){

            for (int j = 1; j < xCoords.length; j++) {

                currentLength = getLengthBetweenPoints(xCoords[i], yCoords[i], xCoords[j], yCoords[j]);

                if (currentLength > maxLength){
                    maxLength = currentLength;
                }
            }
        }

        return maxLength;
    }

    private static double getLengthBetweenPoints(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2));
    }
}
