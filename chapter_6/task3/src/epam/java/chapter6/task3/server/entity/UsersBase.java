package epam.java.chapter6.task3.server.entity;


import epam.java.chapter6.task3.server.dao.ClassDAO;

import java.util.ArrayList;

public class UsersBase {
    private static UsersBase ourInstance = new UsersBase();

    private ArrayList<User> users;

    public static UsersBase getInstance() {
        return ourInstance;
    }

    private UsersBase() {
        users = ClassDAO.getInstance().getUserBaseDAO().getUsersListFromXMLFile();
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
