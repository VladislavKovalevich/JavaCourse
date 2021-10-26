package epam.java.chapter5.task1.entity;

import java.io.*;

public class TextFile extends File{

    public TextFile(String name, String path){
        super(name, path);
    }

    @Override
    public void writeToFile(Object object, boolean isAppend) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        try {
            fileWriter = new FileWriter(super.getFile(), isAppend);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(object.toString());
            bufferedWriter.flush();

            System.out.println("Запись прошла успешно");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object readFromFile() {
        StringBuilder content;
        FileReader fileReader;
        BufferedReader bufferedReader;

        content = new StringBuilder();

        try {
            fileReader = new FileReader(super.getFile());
            bufferedReader = new BufferedReader(fileReader);

            String line;

            line = bufferedReader.readLine();

            while (line != null){
                content.append(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения");
            return null;
        }

        return content.toString();
    }
}
