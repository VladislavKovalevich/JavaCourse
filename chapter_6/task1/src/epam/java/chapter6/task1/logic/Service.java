package epam.java.chapter6.task1.logic;

public class Service {
    private static Service instance = null;

    private final EmailService emailService;
    private final LibraryService libraryService;
    private final PasswordService passwordService;
    private final UserService userService;
    private final MenuService menuService;

    private Service(){
        emailService = new EmailService();
        libraryService = new LibraryService();
        passwordService = new PasswordService();
        userService = new UserService();
        menuService = new MenuService();
    }

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }

        return instance;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }

    public PasswordService getPasswordService() {
        return passwordService;
    }

    public UserService getUserService() {
        return userService;
    }

    public MenuService getMenuService() {
        return menuService;
    }
}
