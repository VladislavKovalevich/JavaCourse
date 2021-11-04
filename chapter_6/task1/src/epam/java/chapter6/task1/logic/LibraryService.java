package epam.java.chapter6.task1.logic;

import epam.java.chapter6.task1.dao.ClassDAO;
import epam.java.chapter6.task1.dao.LibraryDAO;
import epam.java.chapter6.task1.entity.Library;
import epam.java.chapter6.task1.entity.book.Book;
import epam.java.chapter6.task1.entity.book.BookType;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryService {
    private final LibraryDAO libraryDAO;

    public LibraryService() {
        libraryDAO = ClassDAO.getInstance().getLibraryDAO();
    }

    public void addBookToList(){
        Library library;
        EmailService emailService;
        MenuService menuService;

        Book book;

        book = new Book();
        library = Library.getInstance();
        menuService = new MenuService();
        emailService = new EmailService();

        book.setId(library.getBooks().size() + 1);
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

        library.getBooks().add(book);

        libraryDAO.saveBookToFile(book);

        System.out.println("Книга " + book + " была добавлена в библиотеку");

        emailService.notifyAllUsersAboutNewAddedBook(library, book);

    }

    public void editBook(){
        int bookId;
        Library library;
        MenuService menuService;

        library = Library.getInstance();
        menuService = new MenuService();

        bookId = menuService.getIntDataFromConsole("Введите id книги для изменения ее параметров: ", 0, library.getBooks().size());

        if (bookId > 0) {
            editBookParams(bookId);
        }
    }

    private void editBookParams(int bookID){
        int bookParamNumber;
        Library library;
        MenuService menuService;
        Book book;

        library = Library.getInstance();
        menuService = new MenuService();
        book = library.getBooks().get(bookID - 1);

        System.out.println("Включен режим редактирования книги:\n" + book.toString() + "\n");

        bookParamNumber = menuService.getIntDataFromConsole("1 - Изменить название книги\n" +
                "2 - Изменить автора книги\n" +
                "3 - Изменить год изадния книги\n" +
                "4 - Изменить описание книги\n" +
                "5 - Изменить тип книги\n" +
                "0 - Выйти из режима редактирования\n", 0, 5);

        while (bookParamNumber != 0) {
            switch (bookParamNumber) {
                case 1: {
                    book.setName(menuService.getStringDataFromConsole("Введите новое название книги:"));
                    break;
                }
                case 2: {
                    book.setAuthor(menuService.getStringDataFromConsole("Введите нового автора книги:"));
                    break;
                }
                case 3: {
                    book.setYear(menuService.getIntDataFromConsole("Введите новый год издания книги:", 1000, 2021));
                    break;
                }
                case 4: {
                    book.setDescription(menuService.getStringDataFromConsole("Ввведите новое описание книги:"));
                    break;
                }
                case 5: {
                    int bookType;

                    bookType = menuService.getIntDataFromConsole("Введите новый тип книги:\n" +
                            "1 - Бумажный тип\n" +
                            "2 - Электронный тип\n", 1, 2);

                    if (bookType == 1) {
                        book.setBookType(BookType.PAPER);
                    } else {
                        book.setBookType(BookType.ELECTRONIC);
                    }
                    break;
                }
            }

            bookParamNumber = menuService.getIntDataFromConsole("1 - Изменить название книги\n" +
                    "2 - Изменить автора книги\n" +
                    "3 - Изменить год изадния книги\n" +
                    "4 - Изменить описание книги\n" +
                    "5 - Изменить тип книги\n" +
                    "0 - Выйти из режима редактирования\n", 0, 5);
        }

        libraryDAO.saveBookListToFile(library.getBooks());

    }

    public void searchBook(){
        Library library;
        MenuService menuService;
        String keyPhrase;
        ArrayList<Book> searchingBooks;

        searchingBooks = new ArrayList<>();
        library = Library.getInstance();
        menuService = new MenuService();
        keyPhrase = menuService.getStringDataFromConsole("Введите ключевую фразу для поиска книг:");

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(keyPhrase);

        StringBuilder bookInfo;

        for (Book book : library.getBooks()) {

            bookInfo = new StringBuilder();

            bookInfo.append(book.getName()).append(" ");
            bookInfo.append(book.getAuthor()).append(" ");
            bookInfo.append(book.getYear()).append(" ");
            bookInfo.append(book.getDescription()).append(" ");

            matcher = pattern.matcher(bookInfo.toString());

            if (matcher.find()){
                searchingBooks.add(book);
            }
        }

        if (searchingBooks.size() == 0){
            System.out.println("По данному запросу нет никаких совпадений");
        } else {
            for (Book book : searchingBooks) {
                System.out.println(book);
            }
        }
    }

    public void showFirstPage(){
        Library library;

        library = Library.getInstance();

        if (library.getBooks().size() == 0){
            System.out.println("Библиотека пуста");
        }else{
            if (library.getBooks().size() <= 5){

                for (Book book : library.getBooks()) {
                    System.out.println(book);
                }

                System.out.println("----- Страница 1 -----");
            }else {
                showPageByNumber(1);
            }
        }
    }

    public void showPageByNumber(int pageNumber){
        Scanner in;
        Library library;

        int pagesCount;

        library = Library.getInstance();
        in = new Scanner(System.in);

        pagesCount = (library.getBooks().size() - (library.getBooks().size() % 5))/5;
        pagesCount = (library.getBooks().size() % 5 != 0) ? pagesCount + 1 : pagesCount;

        if (pageNumber < pagesCount) {
            System.out.println("---- " + pageNumber + " из " + pagesCount + "----");
            for (int i = 5 * (pageNumber - 1); i < 5 * pageNumber; i++) {
                System.out.println(library.getBooks().get(i));
            }
        } else if (pageNumber == pagesCount) {
            for (int i = 5 * (pageNumber - 1); i < library.getBooks().size(); i++) {
                System.out.println(library.getBooks().get(i));
            }
        }

        System.out.println(pagesCount + " страниц");
        System.out.println("Введите номер страницы (1 - " + pagesCount + "):" +
                "\nВведите \"0\" для выхода в меню.");

        while(!in.hasNextInt()){
            in.next();
            System.out.println("Enter page's number");
        }

        pageNumber = in.nextInt();

        if (pageNumber > 0){
            showPageByNumber(pageNumber);
        }
    }
}
