package epam.java.chapter5.task5.entity.package_type;

public enum PackageType {

    CARDBOARD(23.4),
    PAPER(30.6),
    PLASTIC(41.9);

    private double price;

    PackageType(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
