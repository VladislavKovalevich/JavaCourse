package epam.java.chapter5.task4.entity.material;

/**
 * Класс драгоценных камней. Содержит поля хранящие цвет камня, цену за карат данного камня и количество карат в камне
 */
public class Gem extends Material {
    public Gem(String name, double amountOfMaterial, double pricePerCarat) {
        super(name, amountOfMaterial, pricePerCarat);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
