package epam.java.chapter6.task3.client.logic;


import epam.java.chapter6.task3.client.validator.Validator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClientLogic {
    private ConsoleInputLogic consoleInputLogic;

    public ClientLogic(){
        consoleInputLogic = new ConsoleInputLogic();
    }

    public String[] inputEditFileParams(){
        String[] editParams;
        int fileId;
        int menuItem;

        editParams = new String[4];
        editParams[0] = "edit_file";

        fileId = consoleInputLogic.getIntDataFromConsole("Введите id изменяемого файла", 1, 100);
        editParams[1] = String.valueOf(fileId);

        String menu = "Введите номер поля для редактирования:\n" +
                "1 - Изменить имя студента\n" +
                "2 - Изменить фамилию студента\n" +
                "3 - Изменить группу студента\n" +
                "4 - Изменить дату рождения\n" +
                "5 - Изменить результат за тестирование по математике\n" +
                "6 - Изменить результат за тестирование по русскому языку\n" +
                "7 - Изменить результат за тестирование по физике\n";

        menuItem = consoleInputLogic.getIntDataFromConsole(menu, 1, 7);

        StringBuilder message = new StringBuilder();
        switch (menuItem){
                case 1:{
                    String newName = consoleInputLogic.getStringDataFromConsole("Введите новое имя студента:\n");
                    message.append("name=").append(newName).append("|");
                    break;
                }
                case 2:{
                    String newSurname = consoleInputLogic.getStringDataFromConsole("Введите новою фамилию студента:\n");
                    message.append("surname=").append(newSurname).append("|");
                    break;
                }
                case 3:{
                    int newGroupId = consoleInputLogic.getIntDataFromConsole("Введите номер группы\n", 100, 999);
                    message.append("groupNumber=").append(String.valueOf(newGroupId)).append("|");
                    break;
                }
                case 4:{
                    String newName = consoleInputLogic.getStringDataFromConsole("Введите дату рождения:\n");
                    message.append("birthDate=").append(newName).append("|");
                    break;
                }
                case 5:{
                    int newGroupId = consoleInputLogic.getIntDataFromConsole("Введите количество баллов за русский язык\n", 1, 100);
                    message.append("language=").append(String.valueOf(newGroupId)).append("|");
                    break;
                }
                case 6:{
                    int newGroupId = consoleInputLogic.getIntDataFromConsole("Введите количество баллов за математику\n", 1, 100);
                    message.append("math=").append(String.valueOf(newGroupId)).append("|");
                    break;
                }
                case 7:{
                    int newGroupId = consoleInputLogic.getIntDataFromConsole("Введите количество баллов за физику\n", 1, 100);
                    message.append("physics=").append(String.valueOf(newGroupId)).append("|");
                    break;
                }
        }

        message.deleteCharAt(message.length() - 1);

        editParams[2] = message.toString();

        return editParams;
    }

    public String[] inputSearchParams(){
        String searchParams[];
        int searchMethod;

        searchParams = new String[3];

        searchParams[0] = "search_file";
        searchMethod = consoleInputLogic.getIntDataFromConsole("1 - Поиск по id\n" +
                "2 - Поиск по имени студента\n" +
                "3 - Поиск по фамилии студента\n" +
                "4 - Поиск по группе\n", 0 , 4);

        searchParams[1] = String.valueOf(searchMethod);
        searchParams[2] = consoleInputLogic.getStringDataFromConsole("Введите ключевое слово или сторку для поиска:");

        return searchParams;
    }

    public String[] inputAddFileData(){
        String fileParams[];

        fileParams = new String[8];
        fileParams[0] = "add_file";

        fileParams[1] = consoleInputLogic.getStringDataFromConsole("Введите имя студента: ");
        fileParams[2] = consoleInputLogic.getStringDataFromConsole("Введите фамилию студента: ");
        fileParams[3] = String.valueOf(consoleInputLogic.getIntDataFromConsole("Введите номер группы:", 100, 800));

        String birthDateString;

        birthDateString = consoleInputLogic.getStringDataFromConsole("Введите дату рождения (формат dd-MM-yy)");
        fileParams[4] = birthDateString;

        int mathResult;
        int physicsResult;
        int languageResult;

        mathResult = consoleInputLogic.getIntDataFromConsole("Введите результат ЦТ по математике", 1, 100);
        fileParams[5] = String.valueOf(mathResult);

        physicsResult = consoleInputLogic.getIntDataFromConsole("Введите результат ЦТ по физике", 1, 100);
        fileParams[6] = String.valueOf(physicsResult);

        languageResult = consoleInputLogic.getIntDataFromConsole("Введите результат ЦТ по русскому языку", 1, 100);
        fileParams[7] = String.valueOf(languageResult);

        return fileParams;
    }

    public String[] inputAuthorizationData(){
        String userParams[] = new String[3];

        Validator validator;
        String email;
        String password;

        validator = new Validator();

        System.out.println("--------------Меню авторизации------------");

        email = consoleInputLogic.getStringDataFromConsole("Введите email: ");

        while(!validator.validateEmail(email)){
            email = consoleInputLogic.getStringDataFromConsole("Неверный формат email. Введите email: ");
        }

        userParams[1] = email;

        password = consoleInputLogic.getStringDataFromConsole("Введите пароль:");

        userParams[2] = getSHA1Hash(password);
        userParams[0] = "authorized_user";

        return userParams;
    }

    public String getRequest(String[] strings) {
        StringBuilder stringBuilder;

        stringBuilder = new StringBuilder();

        for (String s : strings) {
            stringBuilder.append(s).append("|");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    private static String getSHA1Hash(String password){
        StringBuilder stringHashCode;
        byte[] bytes;
        MessageDigest messageDigest;

        stringHashCode = new StringBuilder();

        try {

            messageDigest = MessageDigest.getInstance("sha-1");
            bytes = messageDigest.digest(password.getBytes());

            for (byte b: bytes) {
                stringHashCode.append(String.format("%02x", b));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return stringHashCode.toString();
    }
}
