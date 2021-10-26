package epam.java.chapter6.task3.server.service;

public class Service {
    private static Service instance;

    private UserService userService;
    private StudentFilesService studentFilesService;

    private Service(){
        userService = new UserService();
        studentFilesService = new StudentFilesService();
    }

    public static Service getInstance() {
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public StudentFilesService getStudentFilesService() {
        return studentFilesService;
    }
}
