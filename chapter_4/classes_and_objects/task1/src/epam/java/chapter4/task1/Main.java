package epam.java.chapter4.task1;

import epam.java.chapter4.task1.action.Test1Action;
import epam.java.chapter4.task1.entity.Test1;

/**
 * Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
 * переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных.
 */
public class Main {
    public static void main(String[] args) {
        Test1 test1;
        Test1Action test1Action;

        test1 = new Test1(4, 8);
        test1Action = new Test1Action();

        System.out.println(test1.toString());
        System.out.println(test1Action.getSum(test1));
        System.out.println(test1Action.getMaxValue(test1));

        test1.setX(5);
        test1.setY(10);

        System.out.println(test1.toString());
        System.out.println(test1Action.getSum(test1));
        System.out.println(test1Action.getMaxValue(test1));
    }
}
