package epam.java.chapter6.task1.logic;

import epam.java.chapter6.task1.command.CommandEnum;
import epam.java.chapter6.task1.controller.Controller;
import epam.java.chapter6.task1.controller.ControllerClass;
import epam.java.chapter6.task1.entity.Library;
import epam.java.chapter6.task1.entity.user.UserType;

import java.util.Scanner;

public class MenuService {

    private static final Controller controller = ControllerClass.getInstance();

    public MenuService(){

    }

    public void getAdminsCommands(int menuItemsCount) {
        int menuItem;

        menuItem = getMenuItem(menuItemsCount);

        while(menuItem != 0) {
            switch (menuItem) {
                case 1: {
                    controller.execute(CommandEnum.SHOW_BOOKS);
                    break;
                }
                case 2: {
                    controller.execute(CommandEnum.SEARCH_BOOK);
                    break;
                }
                case 3: {
                    controller.execute(CommandEnum.ADD_BOOK);
                    break;
                }
                case 4: {
                    controller.execute(CommandEnum.EDIT_BOOK);
                    break;
                }
                case 5: {
                    controller.execute(CommandEnum.ADD_USER);
                    break;
                }
            }

            menuItem = getMenuItem(menuItemsCount);
        }
    }

    public void getUserCommands(int menuItemsCount) {
        int menuItem;

        menuItem = getMenuItem(menuItemsCount);

        while(menuItem != 0) {
            switch (menuItem) {
                case 1: {
                    controller.execute(CommandEnum.SHOW_BOOKS);
                    break;
                }
                case 2: {
                    controller.execute(CommandEnum.SEARCH_BOOK);
                    break;
                }
                case 3: {
                    controller.execute(CommandEnum.SUGGEST_NEW_BOOK);
                    break;
                }
            }

            menuItem = getMenuItem(menuItemsCount);
        }
    }

    private int getMenuItem(int menuItemsCount) {
        Scanner in;
        int menuItem = -1;
        Library library;

        library = Library.getInstance();
        in = new Scanner(System.in);

        while(menuItem < 0 || menuItem >= menuItemsCount) {

            if (library.getAuthorizedUser().getRole().equals(UserType.USER)) {
                System.out.println("1 - Отобразить список книг\n" +
                        "2 - Найти книгу\n" +
                        "3 - Предложить новую книгу\n" +
                        "0 - Выйти из приложения\n");
            } else {
                System.out.println("1 - Отобразить список книг\n" +
                        "2 - Найти книгу\n" +
                        "3 - Добавить книгу\n" +
                        "4 - Изменить книгу\n" +
                        "5 - Добавить нового пользователя\n" +
                        "0 - Выйти из приложения\n");
            }

            menuItem = in.nextInt();
            in.nextLine();
        }

        return menuItem;
    }

    public String getStringDataFromConsole(String consoleString){
        String inputData;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println(consoleString);
        while(!in.hasNextLine()){
            System.out.println(consoleString);
            in.next();
        }

        inputData = in.nextLine();

        return inputData;
    }

    public int getIntDataFromConsole(String consoleString, int minValue, int maxValue){
        int inputData;
        Scanner in;

        in = new Scanner(System.in);

        System.out.println(consoleString);
        while(!in.hasNextInt()){
            System.out.println(consoleString);
            in.next();
        }

        inputData = in.nextInt();
        in.nextLine();

        if (inputData >= minValue && inputData <= maxValue) {
            return inputData;
        }else{
            return getIntDataFromConsole(consoleString, minValue, maxValue);
        }
    }
}
