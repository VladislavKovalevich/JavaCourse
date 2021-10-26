package epam.java.chapter5.task4.entity.material;

public abstract class Material {
    private String name;
    private double pricePerMeasure;
    private double price;

    public Material(String name, double amountOfMaterial, double pricePerMeasure) {
        this.name = name;
        this.price = pricePerMeasure * amountOfMaterial;
        this.pricePerMeasure = pricePerMeasure;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPricePerMeasure() {
        return pricePerMeasure;
    }
}
