package epam.java.chapter6.task2.service;


import epam.java.chapter6.task2.controller.Controller;
import epam.java.chapter6.task2.controller.ControllerClass;
import epam.java.chapter6.task2.dao.NoteBookDAO;

import java.util.Scanner;

public class UserService {
    UserService(){
    }

    public void getUserMenu(){
        int menuItem;
        int maxMenuItems;
        Controller controller;
        NoteBookDAO noteBookDAO;

        maxMenuItems = 6;
        menuItem = getMenuItem(maxMenuItems);
        controller = ControllerClass.getInstance();
        noteBookDAO = new NoteBookDAO();

        while (menuItem != 0){

            switch (menuItem){
                case 1:{
                    controller.execute("show_notes");
                    break;
                }
                case 2:{
                    controller.execute("add_note");
                    break;
                }
                case 3:{
                    controller.execute("edit_note");
                    break;
                }
                case 4:{
                    controller.execute("search_note");
                    break;
                }
                case 5:{
                    controller.execute("delete_note");
                    break;
                }
            }

            menuItem = getMenuItem(maxMenuItems);
        }

        noteBookDAO.saveDataToFile();
    }

    private int getMenuItem(int maxMenuItem) {
        int menuItem;
        Scanner in;

        menuItem = -1;
        in = new Scanner(System.in);

        while(menuItem < 0 || menuItem >= maxMenuItem) {
            System.out.println("1 - Отображение списка заметок\n" +
                    "2 - Добавление новой заметки\n" +
                    "3 - Редактирование заметки\n" +
                    "4 - Поиск заметки\n" +
                    "5 - Удаление заметки\n" +
                    "0 - Выход\n");
            menuItem = in.nextInt();
            in.nextLine();
        }


        return menuItem;
    }
}
