package epam.java.chapter2.matrix;

/**
 * Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел
 * (1, 2, 3, ..., n*n) так, что суммы по каждому столбцу, каждой строке и каждой из двух больших
 * диагоналей равны между собой. Построить такой квадрат.
 */
public class Task14 {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix;

        if (n % 2 == 0 && n > 2) {
            // метод формирования квадрата четной размерности
            matrix = squareSubSquareMethod(n);

        }else {
            if (n % 4 == 0) {
                // метод формирования квадрата размерности кратной 4
                matrix = squareRaussBollMethod(n);
            } else {
                // метод формирования квадрата нечетной размерности
                matrix = squareLoubereMethod(n);
            }
        }

       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[i].length; j++) {
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }

    }

    private static int[][] squareSubSquareMethod(int n) {
        int half = n/2;

        int[][] matrix = new int[n][n];
        int[][] tempMatrix;

        tempMatrix = squareLoubereMethod(half);

        // получение значений элементов подквадратов
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }

        for (int i = 0; i < half; i++) {
            for (int j = half; j < n; j++) {
                int x = j-half;
                matrix[i][j] = (tempMatrix[i][x]+2*half*half);
            }
        }

        for (int i = half; i < n; i++) {
            for (int j = 0; j < half; j++) {
                int x = i-half;

                matrix[i][j] = (tempMatrix[x][j]+3*half*half);
            }
        }

        for (int i = half; i < n; i++) {
            for (int j = half; j < n; j++) {
                int x = i-half, y = j-half;
                matrix[i][j] = (tempMatrix[x][y]+half*half);
            }
        }

        // перестановка отдельных элементов
        int move = 0;
        for (int i = 6; i < n; i++) {
            if((i%4!=0)&&(i%2==0)) move++;
        }
        for (int j = matrix.length/2-move; j <= matrix.length/2+move-1; j++) {
            for (int i = 0; i < tempMatrix.length; i++) {

                int key = matrix[i][j];
                matrix[i][j] = matrix[half+i][j];
                matrix[half+i][j] = key;
            }
        }
        for (int j = 0; j <= 1; j++) {
            if (j == 0) {
                int key = matrix[0][0];
                matrix[0][0] = matrix[half][0];
                matrix[half][0] = key;
            }
            if (j == 1) {
                int key = matrix[half - 1][0];
                matrix[half - 1][0] = matrix[n - 1][0];
                matrix[n - 1][0] = key;
            }
        }
        for (int j = half+1; j < n-1; j++) {
            for (int i = 1; i < half-1; i++) {
                int key = matrix[i][1];
                matrix[i][1] = matrix[half+i][1];
                matrix[half+i][1] = key;
            }
        }
        return matrix;
    }


    // метод Раусса-Болла для квадратов с размерностью кратной четырем
    private static int[][] squareRaussBollMethod(int n) {
        int[] matrix[] = new int[n][n],
              tempMatrix[] = new int[n][n];

        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tempMatrix[i][j] = n*n - value;
                value++;
                matrix[i][j] = value;
            }
        }

        int size = 4;
        int x = 0;
        int y = 0;
        for (int i = 0; i < (n*n/16); i++) {
            if (x == (int)Math.sqrt(n*n/16)) {
                x = 0;
                y++;
            }

            for (int j = 0; j < 4; j++) {
                matrix[size*y+j][size*x+j] = tempMatrix[size*y+j][size*x+j];
                matrix[size*y+j][size*x+size-1-j] = tempMatrix[size*y+j][size*x+size-1-j];
            }
            x++;
        }
        return matrix;

    }

    //метод Лубера для n-нечетных квадратов
    private static int[][] squareLoubereMethod(int n) {
        int[][] matrix = new int[n][n];

        int count = 1, y = 0, x = matrix.length/2;

        while (true){
            matrix[y][x] = count;

            count++;
            if (((y == 0) && (x >= n-1)) && (matrix[n-1][0] != 0)){
                y++;
            }
            else {
                y--;
                if (y < 0) {
                    y = n - 1;
                }
                x++;
                if (x == n) {
                    x = 0;
                }
                if(matrix[y][x]!=0){
                    y+=2;
                    x--;
                }
            }

            if(count==n*n+1) break;
        }
        return matrix;
    }
}
