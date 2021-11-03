package epam.java.chapter4.task9;

import epam.java.chapter4.task9.action.BooksDataBaseAction;
import epam.java.chapter4.task9.entity.Book;
import epam.java.chapter4.task9.entity.BooksDataBase;

/**
 *  Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
 * метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */
public class Main {
    public static void main(String[] args) {
        Book[] books;
        BooksDataBase booksDataBase;
        BooksDataBaseAction booksDataBaseAction;

        books = new Book[]{
                new Book(1, "Таинственный остров", "Жюль Верн", "Париж", 1997, 234, 23.9, 3),
                new Book(2, "Пятнадцатилетний капитан", "Дик Сент", "Нью Йорк", 1999, 200, 15.9, 2),
                new Book(3, "Дюна", "Фрэнк Герберт", "Вашингтон", 1970, 341, 34.9, 3),
                new Book(4, "Дети капитана Гранта", "Жюль Верн", "Вашингтон", 1997, 234, 23.9, 1),
                new Book(5, "Сердца трех", "Джек Лондон", "Вашингтон", 2000, 234, 23.9, 1),
        };

        booksDataBase = new BooksDataBase(books);
        booksDataBaseAction= new BooksDataBaseAction();


        String author = "Жюль Верн";

        System.out.println("Книги автора " + author);

        for (Book b : booksDataBaseAction.searchBooksByAuthor(booksDataBase, author)) {
            System.out.println(b.toString());
        }


        String publishingHouse = "Вашингтон";

        System.out.println("Книги печатного дома " + publishingHouse);

        for (Book b : booksDataBaseAction.searchBooksByPublishingHouse(booksDataBase, publishingHouse)) {
            System.out.println(b.toString());
        }


        int year = 1998;

        System.out.println("Книги изданные с "+ year + " года");

        for (Book b : booksDataBaseAction.searchBooksByYear(booksDataBase, year)) {
            System.out.println(b.toString());
        }
    }
}
