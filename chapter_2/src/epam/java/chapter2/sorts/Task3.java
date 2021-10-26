package epam.java.chapter2.sorts;

/**
 * Сортировка выбором. Дана последовательность чисел
 * a1 <= a2 <= ...<= an.Требуется переставить элементы так,
 * чтобы они были расположены по убыванию. Для этого
 * в массиве, начиная с первого, выбирается наибольший
 * элемент и ставится на первое место, а первый - на
 * место наибольшего. Затем, начиная со второго, эта процедура
 * повторяется. Написать алгоритм сортировки выбором.
 */
public class Task3 {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 4, 6, 11, 34, 55};

        for (int i = 0; i < array.length; i++) {

            int maxItemPos = i;
            int maxItem = array[i];

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] > maxItem){
                    maxItemPos = j;
                    maxItem = array[j];
                }

            }

            array[maxItemPos] = array[i];
            array[i] = maxItem;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
