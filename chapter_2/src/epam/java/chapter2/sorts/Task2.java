package epam.java.chapter2.sorts;

import java.util.Arrays;

/**
 * Даны две последовательности a1<= a2 <= ...<= an и b1 <= b2 <= ...<= bm.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 */
public class Task2 {
    public static void main(String[] args) {
        int destCount;
        int srcCount;
        int sumCount;

        int[] arraySrc;
        int[] arrayDest;
        int[] summaryArray;

        destCount = 0;
        srcCount = 0;
        sumCount = 0;

        arraySrc = new int[]{2, 3, 4, 4, 6, 11, 34, 55};
        arrayDest = new int[]{5, 5, 8, 15, 25, 31};
        summaryArray = new int[arraySrc.length + arrayDest.length];

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

        System.out.println(Arrays.toString(summaryArray));
    }
}
