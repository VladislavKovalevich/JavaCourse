package epam.java.chapter6.task3.server.service;


import epam.java.chapter6.task3.server.ServerResponse;
import epam.java.chapter6.task3.server.dao.ClassDAO;
import epam.java.chapter6.task3.server.dao.FilesBaseDAO;
import epam.java.chapter6.task3.server.entity.File;
import epam.java.chapter6.task3.server.entity.FileBase;
import epam.java.chapter6.task3.server.entity.Student;
import epam.java.chapter6.task3.server.entity.TestSubjectType;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentFilesService {
    private final FilesBaseDAO filesBaseDAO = ClassDAO.getInstance().getFilesBaseDAO();

    StudentFilesService(){

    }

    public ServerResponse addFile(String[] args) {
        ServerResponse serverResponse;
        FileBase fileBase;
        File file;
        Student student;
        HashMap<TestSubjectType, Integer> testMap;

        fileBase = FileBase.getInstance();
        testMap = new HashMap<>();

        Date birthDate;

        try {
            birthDate = Student.simpleDateFormat.parse(args[4]);
            student = new Student(args[1], args[2], Integer.parseInt(args[3]), birthDate);
        } catch (ParseException e) {
            serverResponse = new ServerResponse(0, "Неверный формат даты");
            return serverResponse;
        }

        testMap.put(TestSubjectType.MATH, Integer.parseInt(args[5]));
        testMap.put(TestSubjectType.LANGUAGE, Integer.parseInt(args[7]));
        testMap.put(TestSubjectType.PHYSICS, Integer.parseInt(args[6]));

        file = new File(fileBase.getFiles().size() + 1, student, testMap);

        fileBase.getFiles().add(file);
        serverResponse = new ServerResponse(1, "Дело студента добавлено в базу\n");

        filesBaseDAO.saveFilesToXMLFile();

        return serverResponse;
    }

    public ServerResponse editFile(String[] args){
        ServerResponse serverResponse;
        FileBase fileBase;

        fileBase = FileBase.getInstance();
        String editMessage = null;

        for (File f : fileBase.getFiles()) {
            if (f.getId() == Integer.parseInt(args[1])){
                editStudentFile(f, args);
                editMessage = f.toString();
                break;
            }
        }

        if (editMessage != null){
            serverResponse = new ServerResponse(1, editMessage);
        }else{
            serverResponse = new ServerResponse(0, "Дело с заданным id не найденно.\n");
        }

        System.out.println("edit file");

        filesBaseDAO.saveFilesToXMLFile();

        return serverResponse;
    }

    private void editStudentFile(File f, String[] args) {
        String[] nameValue;

        for (String s : args) {
            nameValue = s.split("\\=");

            switch (nameValue[0]){
                case "name":{
                    f.getStudent().setName(nameValue[1]);
                    break;
                }
                case "surname":{
                    f.getStudent().setSurname(nameValue[1]);
                    break;
                }
                case "groupId":{
                    f.getStudent().setGroupNumber(Integer.parseInt(nameValue[1]));
                    break;
                }
                case "birthDate":{
                    try {
                        f.getStudent().setBirthDate(Student.simpleDateFormat.parse(nameValue[1]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "math":{
                    f.getSubjectMap().replace(TestSubjectType.MATH, Integer.parseInt(nameValue[1]));
                    break;
                }
                case "physics":{
                    f.getSubjectMap().replace(TestSubjectType.PHYSICS, Integer.parseInt(nameValue[1]));
                    break;
                }
                case "language":{
                    f.getSubjectMap().replace(TestSubjectType.LANGUAGE, Integer.parseInt(nameValue[1]));
                    break;
                }
            }
        }
    }

    public ServerResponse searchFile(String[] args){
        ServerResponse serverResponse;
        FileBase fileBase;
        Pattern pattern;
        Matcher matcher;
        StringBuilder message;

        message = new StringBuilder("Результаты поиска:");
        fileBase = FileBase.getInstance();

        switch (Integer.parseInt(args[1])) {
            case 1: {
                int fileId;
                fileId = Integer.parseInt(args[2]);
                for (File file : fileBase.getFiles()) {
                    if (file.getId() == fileId){
                        message.append(file.toString()).append("\n");
                    }
                }
                break;
            }
            case 2: {
                pattern = Pattern.compile(args[2].toLowerCase());
                for (File file : fileBase.getFiles()) {
                    matcher = pattern.matcher(file.getStudent().getName());
                    if (matcher.find()){
                        message.append(file.toString()).append("\n");
                    }
                }
                break;
            }
            case 3: {
                pattern = Pattern.compile(args[2].toLowerCase());
                for (File file : fileBase.getFiles()) {
                    matcher = pattern.matcher(file.getStudent().getSurname());
                    if (matcher.find()){
                        message.append(file.toString()).append("\n");
                    }
                }
                break;
            }
            case 4: {
                int groupNumber;
                groupNumber = Integer.parseInt(args[2]);

                for (File file : fileBase.getFiles()) {
                    if (file.getStudent().getGroupNumber() == groupNumber){
                        message.append(file.toString()).append("\n");
                    }
                }
                break;
            }
        }

        if (message.length() > 19){
            serverResponse = new ServerResponse(1, message.toString());
        }else{
            message.append("Пусто").append("\n");
            serverResponse = new ServerResponse(0, message.toString());
        }

        System.out.println("search file");
        return serverResponse;
    }

    public ServerResponse showFiles(String[] args){
        StringBuilder message;
        ServerResponse serverResponse;
        FileBase fileBase;

        message = new StringBuilder("-------Список дел студентов-------\n\n");
        fileBase = FileBase.getInstance();

        for (File f : fileBase.getFiles()) {
            message.append(f.toString()).append("\n\n");
        }

        serverResponse = new ServerResponse(1, message.toString());

        System.out.println("show files");

        return serverResponse;
    }
}
