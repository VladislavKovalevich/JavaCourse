package epam.java.chapter6.task3.server.service;


import epam.java.chapter6.task3.server.ServerResponse;
import epam.java.chapter6.task3.server.entity.User;
import epam.java.chapter6.task3.server.entity.UsersBase;

public class UserService {
    UserService(){

    }

    public ServerResponse authorizedUser(String[] userData){
        UsersBase usersBase;
        String email;
        String password;
        ServerResponse response;

        response = new ServerResponse();
        usersBase = UsersBase.getInstance();
        email = userData[1];
        password = userData[2];

        response.setOperationCode(0);

        for (User u : usersBase.getUsers()) {
            if (u.getEmail().equals(email)){
                if (u.getPassword().equals(password)){
                    response.setOperationCode(1);
                    response.setMessage("Авторизация прошла успешно" + "|" + u.getUserType().toString());
                    break;
                }else {
                    response.setMessage("Неверный пароль");
                    break;
                }
            }
        }

        if (response.getMessage() == null){
            response.setMessage("Пользователь с данным email отсутствует");
        }

        return response;
    }

}
