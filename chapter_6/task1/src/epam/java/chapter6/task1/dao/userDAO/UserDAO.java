package epam.java.chapter6.task1.dao.userDAO;

import epam.java.chapter6.task1.entity.user.User;

import java.util.ArrayList;

public interface UserDAO {
    ArrayList<User> getAllUsers();
    void saveUser(User user);
}
