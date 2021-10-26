package epam.java.chapter6.task1.dao;

import epam.java.chapter6.task1.config.Config;
import epam.java.chapter6.task1.entity.user.User;
import epam.java.chapter6.task1.entity.user.UserType;

import java.io.*;
import java.util.ArrayList;

public class UsersDAO {
    private static final String RESOURCE_USERS_LIST = "usersList.txt";
    private static final String FILE_SEPARATOR = "\\|";

    public ArrayList<User> loadUsersInfoFromFile(){
        ArrayList<User> users = new ArrayList<>();

        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;

        try {

            file = new File(Config.getRootPath() + RESOURCE_USERS_LIST);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();

            while (line != null){
                users.add(buildUserFromString(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return users;
    }

    private User buildUserFromString(String fileLine){
        User user = new User();

        String[] strings = fileLine.split(FILE_SEPARATOR);

        user.setId(Integer.parseInt(strings[0]));
        user.setName(strings[1]);
        user.setSurname(strings[2]);
        user.setEmail(strings[3]);
        user.setPassword(strings[4]);
        user.setRole(UserType.valueOf(strings[5].toUpperCase()));

        return user;
    }


    public void saveUserToFile(User user){
        File file;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        StringBuilder line = new StringBuilder();

        try{
            file = new File(Config.getRootPath() + RESOURCE_USERS_LIST);
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            line.append(user.getId()).append("|");
            line.append(user.getName()).append("|");
            line.append(user.getSurname()).append("|");
            line.append(user.getEmail()).append("|");
            line.append(user.getPassword()).append("|");
            line.append(user.getRole()).append("\n");

            bufferedWriter.append(line.toString());
            bufferedWriter.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
