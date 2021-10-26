package epam.java.chapter6.task2.service;

public class Service {
    private static Service instance;

    private NoteBookService noteBookService = new NoteBookService();
    private UserService userService = new UserService();
    private ConsoleInputService consoleInputService = new ConsoleInputService();

    private Service(){

    }


    public static Service getInstance() {
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }


    public NoteBookService getNoteBookService() {
        return noteBookService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ConsoleInputService getConsoleInputService() {
        return consoleInputService;
    }
}
