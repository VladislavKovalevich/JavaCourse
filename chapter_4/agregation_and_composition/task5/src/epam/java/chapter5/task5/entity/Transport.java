package epam.java.chapter5.task5.entity;

public enum Transport {
    SHIP(80.0),
    TRAIN(50.0),
    BUS(90.0),
    AIRPLANE(140.0);

    private double price;

    Transport(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
