package epam.java.chapter5.task5.entity;

public enum Meal {
    BREAKFAST(8.0),
    LUNCH(10.0),
    DINNER(10.0);

    private double price;

    Meal(double price){
      this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
