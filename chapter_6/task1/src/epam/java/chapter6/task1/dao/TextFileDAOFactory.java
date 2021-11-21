package epam.java.chapter6.task1.dao;

import epam.java.chapter6.task1.dao.libraryDAO.LibraryDAO;
import epam.java.chapter6.task1.dao.libraryDAO.impl.TextFileLibraryDAO;
import epam.java.chapter6.task1.dao.userDAO.impl.TextFileUsersDAO;
import epam.java.chapter6.task1.dao.userDAO.UserDAO;

public class TextFileDAOFactory extends AbstractFactoryDAO {
    @Override
    public LibraryDAO getLibraryDAO() {
        return new TextFileLibraryDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new TextFileUsersDAO();
    }
}
