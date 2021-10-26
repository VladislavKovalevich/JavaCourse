package epam.java.chapter6.task4.entity.ship;

public enum ShipSize {
    SMALL(4),
    MEDIUM(6),
    LARGE(9);

    private int size;

    ShipSize(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
