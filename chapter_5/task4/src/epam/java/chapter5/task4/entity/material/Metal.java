package epam.java.chapter5.task4.entity.material;

/**
 *
 */
public class Metal extends Material {

    public Metal(String name, double amountOfMaterial, double pricePerKilo) {
        super(name, amountOfMaterial, pricePerKilo);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
