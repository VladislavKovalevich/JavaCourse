package epam.java.chapter2.sorts;

/**
 * Даны две последовательности a1<= a2 <= ...<= an и b1 <= b2 <= ...<= bm.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] arraySrc = {2, 3, 4, 4, 6, 11, 34, 55};
        int[] arrayDest = {5, 5, 8, 15, 25, 31};

        int[] summaryArray = new int[arraySrc.length + arrayDest.length];

        int destCount = 0;
        int srcCount = 0;
        int sumCount = 0;

        while(destCount < arrayDest.length && srcCount < arraySrc.length){
            if (arrayDest[destCount] > arraySrc[srcCount]){
                summaryArray[sumCount] = arraySrc[srcCount];
                srcCount++;
            }else{
                summaryArray[sumCount] = arrayDest[destCount];
                destCount++;
            }

            sumCount++;
        }

        if (destCount < arrayDest.length){
            while(destCount < arrayDest.length){
                summaryArray[sumCount] = arrayDest[destCount];
                destCount++;
                sumCount++;
            }
        }else{
            while(srcCount < arraySrc.length){
                summaryArray[sumCount] = arraySrc[srcCount];
                srcCount++;
                sumCount++;
            }
        }


        for (int i = 0; i < summaryArray.length; i++) {
            System.out.print(summaryArray[i] + " ");
        }
    }
}
