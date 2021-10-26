package epam.java.chapter4.task9.action;

import epam.java.chapter4.task9.entity.Book;
import epam.java.chapter4.task9.entity.BooksDataBase;

import java.util.ArrayList;
import java.util.List;

public class BooksDataBaseAction {

    public BooksDataBaseAction(){

    }

    public List<Book> searchBooksByAuthor(BooksDataBase booksDataBase, String author){
        List<Book> books = new ArrayList<>();

        for (Book book: booksDataBase.getBooks()) {
            if (book.getAuthor().compareTo(author) == 0){
                books.add(book);
            }
        }

        return books;
    }

    public List<Book> searchBooksByPublishingHouse(BooksDataBase booksDataBase, String publishingHouse){
        List<Book> books = new ArrayList<>();

        for (Book book: booksDataBase.getBooks()) {
            if (book.getPublishingHouse().compareTo(publishingHouse) == 0){
                books.add(book);
            }
        }

        return books;
    }

    public List<Book> searchBooksByYear(BooksDataBase booksDataBase, int year){
        List<Book> books = new ArrayList<>();

        for (Book book: booksDataBase.getBooks()) {
            if (book.getPublishingDate() > year){
                books.add(book);
            }
        }

        return books;
    }

}
