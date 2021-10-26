package epam.java.chapter2.sorts;

/**
 * Сортировка вставками. Дана последовательность чисел
 * a1, a2, ..., an. Требуется переставить числа в порядке
 * возрастания. Делается это следующим образом. Пусть
 * a1, a2, ..., ai - упорядоченная последовательность, т. е.
 * a1 <= a2 <= ... <= an. Берется следующее число a[i+1]
 * и вставляется в последовательность так, чтобы новая
 * последовательность была тоже возрастающей.
 * Процесс производится до тех пор, пока все элементы от i +1 до n
 * не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
 * с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */
public class Task5 {
    public static void main(String[] args) {
        int[] array = {55, 34, 44, 96, 114, 4, 0, 51, 19, 72};

        int key;
        int lastIndex;
        int firstIndex;

        for (int i = 0; i < array.length; i++) {

            key = array[i];
            lastIndex = i;
            firstIndex = 0;

            lastIndex = binarySearch(firstIndex, lastIndex, array, key);

            for (int j = i; j > lastIndex; j--) {
                array[j] = array[j - 1];
            }

            array[lastIndex] = key;

        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int binarySearch(int firstIndex, int lastIndex, int[] array, int element) {
        int last = lastIndex;
        int first = firstIndex;

        int middle;

        while (first < last){

            middle = first + (last - first)/ 2;

            if (element < array[middle]){
                last = middle;
            }else{
                first = middle + 1;
            }
        }

        return first;
    }
}
