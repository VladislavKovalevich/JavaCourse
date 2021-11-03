package epam.java.chapter4.task5;

import epam.java.chapter4.task5.action.DecimalCounterAction;
import epam.java.chapter4.task5.entity.DecimalCounter;

/**
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
 * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
 * произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
 * позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса
 */

public class Main {
    public static void main(String[] args) {
        DecimalCounter counter;
        DecimalCounterAction counterAction;

        counter = new DecimalCounter(8);
        counterAction = new DecimalCounterAction();

        System.out.println("Инкремент");
        System.out.println(counterAction.getInfoAboutCounter(counter));

        for (int i = 0; i < 12; i++) {
            counter = counterAction.incrementCounter(counter);
            System.out.println(counterAction.getInfoAboutCounter(counter));
        }

        System.out.println();

        System.out.println("Декремент");
        System.out.println(counterAction.getInfoAboutCounter(counter));

        for (int i = 0; i < 12; i++) {
            counter = counterAction.decrementCounter(counter);
            System.out.println(counterAction.getInfoAboutCounter(counter));
        }
    }
}
