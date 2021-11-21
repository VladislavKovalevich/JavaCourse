package epam.java.chapter6.task1.dao.libraryDAO;

import epam.java.chapter6.task1.entity.book.Book;

import java.util.ArrayList;

public interface LibraryDAO {
    ArrayList<Book> getAllBook();
    void saveAllBooks(ArrayList<Book> books);
    void saveBook(Book book);
}
