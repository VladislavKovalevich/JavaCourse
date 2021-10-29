package epam.java.chapter2.sorts;

import java.util.Arrays;

/**
 * Пусть даны две неубывающие последовательности действительных чисел
 * a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
 * Требуется указать те места, на которые нужно вставлять элементы последовательности
 * b1 <= b2 <= ... <= bm в первую последовательность так, чтобы новая последовательность оставалась возрастающей.
 */
public class Task7 {
    public static void main(String[] args) {
        int[] arrayA;
        int[] arrayB;
        int[] fromAtoBIndexArray;
        int currIndex;

        arrayA = new int[]{2, 3, 4};
        arrayB = new int[]{4, 9, 15};
        fromAtoBIndexArray = new int[arrayA.length];
        currIndex = 0;

        for (int i = 0; i < arrayA.length; i++) {
            boolean flag;

            flag = false;

            for (int j = 0; j < arrayB.length; j++) {

                if (arrayB[j] >= arrayA[i] && !flag){

                    fromAtoBIndexArray[currIndex] = i + j;
                    currIndex++;
                    flag = true;

                }
            }

            if (!flag){
                fromAtoBIndexArray[currIndex] = i + arrayB.length;
                currIndex++;
            }
        }

        System.out.println("Индексы для вставки последовательности А в последовательность В:");
        System.out.println(Arrays.toString(fromAtoBIndexArray));

        int[] fromBtoAIndexArray;

        fromBtoAIndexArray = new int[arrayB.length];

        currIndex = 0;

        for (int i = 0; i < arrayB.length; i++) {

            boolean flag;

            flag = false;

            for (int j = 0; j < arrayA.length; j++) {

                if (arrayB[i] <= arrayA[j] && !flag){

                    fromBtoAIndexArray[currIndex] = i + j;
                    currIndex++;
                    flag = true;

                }

            }

            if (!flag){
                fromBtoAIndexArray[currIndex] = i + arrayA.length;
                currIndex++;
            }
        }

        System.out.println("Индексы для вставки последовательности B в последовательность A:");
        System.out.println(Arrays.toString(fromBtoAIndexArray));

    }
}
