package epam.java.chapter6.task1.entity.book;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private String description;
    private int year;
    private BookType bookType;

    public Book(){

    }

    public Book(int id, String name, String author, String description, int year, BookType bookType) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.year = year;
        this.bookType = bookType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                year == book.year &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(description, book.description) &&
                bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, description, year, bookType);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", bookType=" + bookType +
                '}';
    }
}
