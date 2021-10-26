package epam.java.chapter4.task9.entity;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int publishingDate;
    private int pagesCount;
    private double price;
    private int cover;

    public Book(int id, String title, String author, String publishingHouse, int publishingDate, int pagesCount, double price, int cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publishingDate = publishingDate;
        this.pagesCount = pagesCount;
        this.price = price;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(int publishingDate) {
        this.publishingDate = publishingDate;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nid=" + id +
                ",\ntitle='" + title +
                ",\nauthor='" + author +
                ",\npublishingHouse='" + publishingHouse +
                ",\npublishingDate=" + publishingDate +
                ",\npagesCount=" + pagesCount +
                ",\nprice=" + price +
                ",\ncover=" + cover +
                "\n}\n";
    }
}
