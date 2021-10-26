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
        int[] arraySrc = {2, 5, 13};
        int[] arrayDest = {4, 9, 15};

        int[] fromAtoBIndexArray = new int[arraySrc.length];

        int currIndex = 0;

        for (int i = 0; i < arraySrc.length; i++) {
            boolean flag = false;

            for (int j = 0; j < arrayDest.length; j++) {

                if (arrayDest[j] >= arraySrc[i] && !flag){

                    fromAtoBIndexArray[currIndex] = i + j;
                    currIndex++;
                    flag = true;

                }
            }

            if (!flag){
                fromAtoBIndexArray[currIndex] = i + arrayDest.length;
                currIndex++;
            }
        }

        System.out.println("Индексы для вставки последовательности А в последовательность В:");
        System.out.println(Arrays.toString(fromAtoBIndexArray));

        int[] fromBtoAIndexArray = new int[arrayDest.length];

        currIndex = 0;
        for (int i = 0; i < arrayDest.length; i++) {

            boolean flag = false;

            for (int j = 0; j < arraySrc.length; j++) {

                if (arrayDest[i] <= arraySrc[j] && !flag){

                    fromBtoAIndexArray[currIndex] = i + j;
                    currIndex++;
                    flag = true;

                }

            }

            if (!flag){
                fromBtoAIndexArray[currIndex] = i + arraySrc.length;
                currIndex++;
            }
        }

        System.out.println("Индексы для вставки последовательности B в последовательность A:");
        System.out.println(Arrays.toString(fromBtoAIndexArray));

    }
}
