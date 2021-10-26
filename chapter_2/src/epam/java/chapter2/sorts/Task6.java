package epam.java.chapter2.sorts;

/**
 * Сортировка Шелла. Дан массив n действительных чисел.
 * Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента a[i] и a[i+1].
 * Если a[i] <= a[i+1], то продвигаются на один элемент вперед.
 * Если a[i] > a[i+1], то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 */
public class Task6 {
    public static void main(String[] args) {
        int[] array = {55, 34, 44, 96, 114, 4, 0, 51, 19, 72};

        for (int i = 0; i < array.length - 1;) {

            if (array[i] > array[i + 1]){

                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;

                if (i != 0) {
                    i--;
                }

            }else if (i != array.length - 1){
                i++;
            }

        }

        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
