package epam.java.chapter5.task1;

import epam.java.chapter5.task1.entity.TextFile;

/**
 * Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */
public class Main {
    public static void main(String[] args) {
        TextFile textFile;

        textFile = new TextFile("testRename.txt", "D:\\temp-2\\tmp-1\\");
        textFile.createFile();

        textFile.renameFile("testRename1.txt");

        textFile.writeToFile("Some info\n", true);

        String content;

        content = (String) textFile.readFromFile();

        System.out.println("Содержимое файла: " + content);

        textFile.deleteFile();
    }
}
