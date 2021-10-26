package epam.java.chapter5.task5.entity.sweets;

public class Biscuits extends Sweets {

    public Biscuits(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Biscuits = " + super.getName() + " / " +super.getPrice() + "\n";
    }
}
