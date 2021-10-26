package epam.java.chapter5.task5.entity;

public enum TourType {
    CRUISE(50.0),
    SHOPPING(60.0),
    RECREATION(150.0),
    EXCURSION(105.0);

    private double price;

    TourType(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
