package epam.java.chapter5.task1.entity;

import java.io.IOException;

public abstract class File {
    private String name;
    private Directory directory;
    private java.io.File file;

    public File(){

    }

    public File(String name, String path){
        this.directory = new Directory(path);
        this.name = name;
        this.file = new java.io.File(directory.getDirectory().getAbsolutePath()+ "\\" + name);
    }

    public java.io.File getFile() {
        return file;
    }

    public abstract void writeToFile(Object object, boolean isAppend);

    public abstract Object readFromFile();

    public void createFile(){
        try {
            if (!file.isFile()) {
                if (file.createNewFile()){
                    System.out.println("Создан новый файл " + directory.getDirectory().getAbsolutePath() + "\\" + name);
                }else{
                    System.out.println("Ошибка создания файла");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания файла");
        }
    }

    public void renameFile(String newName){
        java.io.File file;

        file = new java.io.File(this.directory.getDirectory().getAbsolutePath() + "\\" + newName);

        if (this.file.renameTo(file)){
            this.file = file;
            System.out.println("Файл успешно переименован");
        }else{
            System.out.println("Ошибка переименования");
        }
    }

    public void deleteFile(){
        if (file.isFile()){
            if (file.delete()){
                System.out.println("Файл был удален");
            }else{
                System.out.println("Ошибка удаления файла");
            }
        }else {
            System.out.println("Файл не существует");
        }
    }
}
