package epam.java.chapter6.task1.dao.libraryDAO.impl;


import epam.java.chapter6.task1.config.Config;
import epam.java.chapter6.task1.dao.libraryDAO.LibraryDAO;
import epam.java.chapter6.task1.entity.book.Book;
import epam.java.chapter6.task1.entity.book.BookType;

import java.io.*;
import java.util.ArrayList;

public class TextFileLibraryDAO implements LibraryDAO {
    private static final String RESOURCE_BOOKS_LIST = "booksList.txt";
    private static final String FILE_SEPARATOR = "\\|";

    @Override
    public ArrayList<Book> getAllBook() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            File file = new File(Config.getRootPath() + RESOURCE_BOOKS_LIST);

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null){
                books.add(buildBookFromString(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return books;
    }

    @Override
    public void saveAllBooks(ArrayList<Book> books) {
        File file;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        StringBuilder line;

        try{

            file = new File(Config.getRootPath() + RESOURCE_BOOKS_LIST);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);


            for (Book book : books) {
                line = new StringBuilder();

                line.append(book.getId()).append("|");
                line.append(book.getName()).append("|");
                line.append(book.getAuthor()).append("|");
                line.append(book.getYear()).append("|");
                line.append(book.getDescription()).append("|");
                line.append(book.getBookType()).append("\n");

                bufferedWriter.write(line.toString());
            }


            bufferedWriter.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void saveBook(Book book) {
        File file;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        StringBuilder line = new StringBuilder();

        try{
            file = new File(Config.getRootPath() + RESOURCE_BOOKS_LIST);
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            line.append(book.getId()).append("|");
            line.append(book.getName()).append("|");
            line.append(book.getAuthor()).append("|");
            line.append(book.getYear()).append("|");
            line.append(book.getDescription()).append("|");
            line.append(book.getBookType()).append("\n");

            bufferedWriter.append(line.toString());
            bufferedWriter.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private Book buildBookFromString(String fileLine){
        Book book = new Book();

        String[] strings = fileLine.split(FILE_SEPARATOR);

        book.setId(Integer.parseInt(strings[0]));
        book.setName(strings[1]);
        book.setAuthor(strings[2]);
        book.setYear(Integer.parseInt(strings[3]));
        book.setDescription(strings[4]);
        book.setBookType(BookType.valueOf(strings[5].toUpperCase()));

        return book;
    }

}
