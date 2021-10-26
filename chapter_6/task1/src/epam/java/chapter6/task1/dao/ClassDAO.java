package epam.java.chapter6.task1.dao;

public class ClassDAO {
    private static ClassDAO instance;

    private LibraryDAO libraryDAO;
    private UsersDAO usersDAO;

    private ClassDAO(){
        usersDAO = new UsersDAO();
        libraryDAO = new LibraryDAO();
    }

    public static ClassDAO getInstance(){
        if (instance == null){
            instance = new ClassDAO();
        }

        return instance;
    }

    public UsersDAO getUsersDAO() {
        return usersDAO;
    }

    public LibraryDAO getLibraryDAO() {
        return libraryDAO;
    }

}
