package epam.java.chapter6.task1.dao;

import epam.java.chapter6.task1.dao.libraryDAO.LibraryDAO;
import epam.java.chapter6.task1.dao.userDAO.UserDAO;

public class JSONDAOFactory extends AbstractFactoryDAO {
    @Override
    public LibraryDAO getLibraryDAO() {
        return null;
    }

    @Override
    public UserDAO getUserDAO() {
        return null;
    }
}
