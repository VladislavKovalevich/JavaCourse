package epam.java.chapter6.task1.dao;

import epam.java.chapter6.task1.dao.libraryDAO.LibraryDAO;
import epam.java.chapter6.task1.dao.userDAO.UserDAO;

public abstract class AbstractFactoryDAO {
    public static final int TEXT_FILE = 1;
    public static final int JSON_FILE = 2;

    public abstract LibraryDAO getLibraryDAO();
    public abstract UserDAO getUserDAO();

    public static AbstractFactoryDAO getDAOFactory(int whichFactory){
        switch (whichFactory){
            case TEXT_FILE:{
                return new TextFileDAOFactory();
            }
            case JSON_FILE:{
                return new JSONDAOFactory();
            }
            default:{
                throw new IllegalArgumentException();
            }
        }
    }
}
