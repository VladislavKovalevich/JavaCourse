package epam.java.chapter4.task9.entity;

public class BooksDataBase {
    private Book[] books;

    public BooksDataBase(Book[] books){
        this.books = books;
    }


    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
