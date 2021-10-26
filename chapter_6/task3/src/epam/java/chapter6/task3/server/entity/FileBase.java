package epam.java.chapter6.task3.server.entity;


import epam.java.chapter6.task3.server.dao.ClassDAO;

import java.util.ArrayList;

public class FileBase {
    private static FileBase fileBase;

    private ArrayList<File> files;

    private FileBase(){
        files = ClassDAO.getInstance().
                getFilesBaseDAO().
                getFilesFromXMLFile();
    }

    public static FileBase getInstance(){
        if (fileBase == null){
            fileBase = new FileBase();
        }
        return fileBase;
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}
