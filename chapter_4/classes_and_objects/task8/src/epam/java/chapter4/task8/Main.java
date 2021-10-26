package epam.java.chapter4.task8;

import epam.java.chapter4.task8.action.CustomerDataBaseAction;
import epam.java.chapter4.task8.entity.Customer;
import epam.java.chapter4.task8.entity.CustomerDataBase;

import java.util.ArrayList;

/**
 *  Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 *
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
public class Main {
    public static void main(String[] args) {
        long min = 1000;
        long max = 2000;

        ArrayList<Customer> customers;

        customers = new ArrayList<>();

        customers.add(new Customer(1, "Mihalov", "Anton", "Andreevich", "Minsk", 2345, 3345));
        customers.add(new Customer(2, "Antonov", "Petr", "Petrovich", "Grodno", 1001, 9853));
        customers.add(new Customer(3, "Andreev", "Vlad", "Olegovich", "Brest", 1009, 1934));
        customers.add(new Customer(4, "Miheev", "Andrey", "Nikolaevich", "Vitebsk", 3092, 3235));
        customers.add(new Customer(5, "Korneev", "Oleg", "Vladimirovich", "Mogilev", 5042, 5252));
        customers.add(new Customer(6, "Byhau", "Mihail", "Ivaovich", "Gomel", 4039, 5464));
        customers.add(new Customer(7, "Qwerty", "Ivan", "Andreevich", "Minsk", 2941, 2257));


        CustomerDataBase customerDataBase;
        CustomerDataBaseAction customerDataBaseAction;

        customerDataBase = new CustomerDataBase(customers);
        customerDataBaseAction = new CustomerDataBaseAction();

        System.out.println("Список клиентов с номерами карточек от " + min + " до " + max);
        System.out.println(customerDataBaseAction.searchCustomersByCreditCardNumber(customerDataBase, min, max));
        System.out.println();

        customerDataBaseAction.sortCustomersByName(customerDataBase);
        System.out.println("Список клиентов, отсортированных по алфавиту");
        System.out.println(customerDataBase);
    }
}
