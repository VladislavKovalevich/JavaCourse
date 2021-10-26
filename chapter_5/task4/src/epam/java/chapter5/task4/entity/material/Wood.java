package epam.java.chapter5.task4.entity.material;

public class Wood extends Material {
    public Wood(String name, double amountOfMaterial, double pricePerMeasure) {
        super(name, amountOfMaterial, pricePerMeasure);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
