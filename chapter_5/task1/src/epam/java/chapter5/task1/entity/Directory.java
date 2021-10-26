package epam.java.chapter5.task1.entity;

import java.io.File;

public class Directory {
    private java.io.File directory;

    public Directory(String path) {
        this.directory = new File(path);
        if (this.directory.mkdir()){
            System.out.println("Создана новая папка: " + directory.getAbsolutePath());
        }
    }

    public File getDirectory() {
        return directory;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "path='" + directory.getName() + '\'' +
                '}';
    }
}
