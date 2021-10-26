package epam.java.chapter5.task5.entity.sweets;

public class Chocolate extends Sweets {

    public Chocolate(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Chocolate = " + super.getName() + " / " + super.getPrice() + "\n";
    }
}
