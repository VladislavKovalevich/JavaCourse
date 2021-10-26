package epam.java.chapter5.task5.entity.sweets;

public abstract class Sweets {
    private String name;
    private double price;

    public Sweets(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " / " + price;
    }
}