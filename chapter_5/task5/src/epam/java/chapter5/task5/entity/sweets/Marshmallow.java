package epam.java.chapter5.task5.entity.sweets;

public class Marshmallow extends Sweets {

    public Marshmallow(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Marshmallow = " + super.getName() + " / " + super.getPrice() + "\n";
    }
}
