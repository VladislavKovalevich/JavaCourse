package epam.java.chapter6.task1.entity;

import epam.java.chapter6.task1.dao.AbstractFactoryDAO;
import epam.java.chapter6.task1.entity.book.Book;
import epam.java.chapter6.task1.entity.user.User;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private User authorizedUser;

    private static Library instance = new Library();

    private Library(){
        // загрузка библиотеки
        this.books = AbstractFactoryDAO.getDAOFactory(AbstractFactoryDAO.TEXT_FILE).getLibraryDAO().getAllBook();
        this.users = AbstractFactoryDAO.getDAOFactory(AbstractFactoryDAO.TEXT_FILE).getUserDAO().getAllUsers();
    }

    public static Library getInstance() {
        return instance;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", users=" + users +
                ", authorizedUser=" + authorizedUser +
                '}';
    }
}
