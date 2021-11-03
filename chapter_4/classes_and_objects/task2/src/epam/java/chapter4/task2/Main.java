package epam.java.chapter4.task2;

import epam.java.chapter4.task2.entity.Test2;

/**
 * Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
 * конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
 * класса.
 */
public class Main {
    public static void main(String[] args) {
        Test2 example1;
        Test2 example2;

        example1 = new Test2();
        example2 = new Test2(3, 5);

        System.out.println(example1.toString());
        System.out.println(example2.toString());

        example2.setX(6);
        example2.setY(99);

        System.out.println(example2.getX() + "; " + example2.getY());
    }
}
