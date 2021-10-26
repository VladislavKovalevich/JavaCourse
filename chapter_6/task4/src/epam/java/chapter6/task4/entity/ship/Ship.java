package epam.java.chapter6.task4.entity.ship;

public class Ship {
    private String name;
    private int cargoCount;
    private ShipSize maxSize;
    private boolean isLoaded;

    public Ship(String name, ShipSize maxSize, boolean isLoaded, int cargoCount) {
        this.name = name;
        this.cargoCount = cargoCount;
        this.maxSize = maxSize;
        this.isLoaded = isLoaded;
    }

    public String getName() {
        return name;
    }

    public ShipSize getMaxSize() {
        return maxSize;
    }

    public int getCargoCount(){
        return this.cargoCount;
    }

    public void addCargo(int cargoCount){
        this.cargoCount += cargoCount;
    }

    public void removeCargo(int cargoCount){
        this.cargoCount -= cargoCount;
    }

    public boolean isShipStorageFull(){
        if (cargoCount >= maxSize.getSize()){
            return false;
        }

        return true;
    }

    public boolean isShipStorageEmpty(){
        if (cargoCount <= 0){
            return false;
        }

        return true;
    }


    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(".Название = " + name +
                ". Количество контейнеров = " + cargoCount +
                "/" + maxSize.getSize());

        if (this.isLoaded){
            stringBuilder.append(". На выгрузку контейнеров");
        }else {
            stringBuilder.append(". На загрузку контейнеров");
        }

        return stringBuilder.toString();
    }
}
