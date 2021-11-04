package epam.java.chapter6.task4.entity;


import epam.java.chapter6.task4.entity.ship.Ship;
import epam.java.chapter6.task4.entity.ship.ShipQueue;

public class Dock implements Runnable{
    private int dockNumber;
    private ShipQueue shipQueue;
    private Port port;

    public Dock(ShipQueue shipQueue, int dockNumber, Port port) {
        this.dockNumber = dockNumber;
        this.shipQueue = shipQueue;
        this.port = port;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().setName("Dock" + dockNumber);

                Thread.sleep(500);
                Ship ship;

                ship = shipQueue.getShip();

                if (ship != null){

                    if (ship.isLoaded()){
                        uploadCargoFromShip(ship);
                    }else {
                        loadCargoIntoShip(ship);
                    }

                    System.out.println("Корабль" + ship.getName() + " покинул доки " + Thread.currentThread().getName());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void loadCargoIntoShip(Ship ship) throws InterruptedException {
        while (ship.isShipStorageFull()){

            Thread.sleep(3000);

            port.removeCargo(1);
            ship.addCargo(1);

            System.out.println(Thread.currentThread().getName() + ": Загрузка," + ship.getName() + " " + ship.getCargoCount() + "/" + ship.getMaxSize().getSize());
        }
    }

    private void uploadCargoFromShip(Ship ship) throws InterruptedException {
        while (ship.isShipStorageEmpty()){
            Thread.sleep(3000);

            port.addCargo(1);
            ship.removeCargo(1);

            System.out.println(Thread.currentThread().getName() + ": Разгрузка," + ship.getName() + " " + ship.getCargoCount() + "/" + ship.getMaxSize().getSize());
        }
    }
}