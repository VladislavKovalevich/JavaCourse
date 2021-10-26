package epam.java.chapter6.task3.server.dao;

public class ClassDAO {
    private static ClassDAO classDAO;

    private FilesBaseDAO filesBaseDAO;
    private UserBaseDAO userBaseDAO;

    private ClassDAO(){
        filesBaseDAO = new FilesBaseDAO();
        userBaseDAO = new UserBaseDAO();
    }

    public static ClassDAO getInstance(){
        if (classDAO == null){
            classDAO = new ClassDAO();
        }
        return classDAO;
    }

    public FilesBaseDAO getFilesBaseDAO() {
        return filesBaseDAO;
    }

    public UserBaseDAO getUserBaseDAO() {
        return userBaseDAO;
    }
}
