package epam.java.chapter6.task1.logic;

import epam.java.chapter6.task1.dao.ClassDAO;
import epam.java.chapter6.task1.dao.UsersDAO;
import epam.java.chapter6.task1.entity.Library;
import epam.java.chapter6.task1.entity.book.Book;
import epam.java.chapter6.task1.entity.book.BookType;
import epam.java.chapter6.task1.entity.user.User;
import epam.java.chapter6.task1.entity.user.UserType;

import java.util.Scanner;

public class UserService {
    private final UsersDAO usersDAO;

    public UserService(){
        usersDAO = ClassDAO.getInstance().getUsersDAO();
    }

    public void authorization(){
        MenuService menuService;
        Library library;
        Scanner in;
        String email;
        String password;
        PasswordService passwordService;

        library = Library.getInstance();
        menuService = new MenuService();
        in = new Scanner(System.in);
        passwordService = new PasswordService();

        System.out.println("Введите логин");
        while (!in.hasNextLine()){
            in.next();
            System.out.println("Введите логин");
        }

        email = in.nextLine();


        System.out.println("Введите пароль");
        while (!in.hasNextLine()){
            in.next();
            System.out.println("Введите пароль");
        }

        password = in.nextLine();

        boolean isAuthorized = false;

        for (User user : library.getUsers()) {

            if (user.getEmail().equals(email)){

                if (passwordService.checkInputPassword(user, password)) {
                    isAuthorized = true;
                    library.setAuthorizedUser(user);

                    if (user.getRole().equals(UserType.USER)) {
                        menuService.getUserCommands(4);
                    } else {
                        menuService.getAdminsCommands(6);
                    }
                }

                break;
            }
        }

        if (!isAuthorized){
            System.out.println("Ошбика авторизации. Неревный пароль или почта");
            authorization();
        }
    }

    private boolean isEmailExist(String newLogin){
        boolean isLoginExist;
        Library library;

        isLoginExist = false;
        library = Library.getInstance();

        for (User user: library.getUsers()) {
            if (user.getEmail().equals(newLogin)){
                isLoginExist = true;
                break;
            }
        }

        return isLoginExist;
    }

    public void addUser(){
        Library library;
        MenuService menuService;
        User user;
        PasswordService passwordService;

        String email;
        String password;

        library = Library.getInstance();
        menuService = new MenuService();
        user = new User();
        passwordService = new PasswordService();

        user.setId(library.getUsers().size() + 1);
        user.setName(menuService.getStringDataFromConsole("Введите имя пользователя:"));
        user.setSurname(menuService.getStringDataFromConsole("Введите фамилию пользователя:"));

        email = menuService.getStringDataFromConsole("Введите почту нового пользователя:");

        while(isEmailExist(email) && !validateEmail(email)){
            System.out.println("Некорретный email! Данный email не соответствует стандарту или уже существует.");
            email = menuService.getStringDataFromConsole("Введите почту нового пользователя:");
        }

        user.setEmail(email);

        password = menuService.getStringDataFromConsole("Введите пароль:");

        user.setPassword(passwordService.getSHA1Hash(password));

        int userType;

        userType = menuService.getIntDataFromConsole("Введите тип пользователя:\n" +
                "1 - обычный пользователь\n" +
                "2 - администратор", 1, 2);

        if (userType == 1){
            user.setRole(UserType.USER);
        }else{
            user.setRole(UserType.ADMINISTRATOR);
        }

        library.getUsers().add(user);

        usersDAO.saveUserToFile(user);
    }

    private boolean validateEmail(String email) {
        boolean isValid = false;

        if (email.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")){
            isValid = true;
        }

        return isValid;
    }

    public void suggestNewBook(User user){
        MenuService menuService;
        EmailService emailService;
        Book book;

        menuService = new MenuService();
        emailService = new EmailService();
        book = new Book();

        book.setName(menuService.getStringDataFromConsole("Введите название книги: "));
        book.setAuthor(menuService.getStringDataFromConsole("Введите автора книги: "));
        book.setYear(menuService.getIntDataFromConsole("Введите год выхода книги: ", 1000, 2021));
        book.setDescription(menuService.getStringDataFromConsole("Введите описание книги"));

        int bookType;

        bookType = menuService.getIntDataFromConsole("Выберите тип книги:\n" +
                "1 - бумажный вариант\n" +
                "2 - электроныый вариант\n", 1, 2);

        if (bookType == 1){
            book.setBookType(BookType.PAPER);
        }else{
            book.setBookType(BookType.ELECTRONIC);
        }

        emailService.notifyAdminAboutNewBook(book);
    }
}
