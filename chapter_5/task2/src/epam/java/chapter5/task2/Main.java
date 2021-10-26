package epam.java.chapter5.task2;

import epam.java.chapter5.task2.entity.Payment;

/**
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
 * нескольких товаров.
 */
public class Main {
    public static void main(String[] args) {
        Payment payment;

        payment = new Payment(
                new Payment().new Product("Sprite", 4.0, 2),
                new Payment().new Product("Mars", 16.0, 3),
                new Payment().new Product("Snickers", 13.5, 5),
                new Payment().new Product("Fanta", 9.5, 2)
        );

        System.out.println(payment.toString());

    }
}
