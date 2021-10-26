package epam.java.chapter6.task4.entity.ship;

import java.util.ArrayList;
import java.util.List;

public class ShipQueue {
    private List<Ship> shipQueue;
    private static final int maxShipInQueue = 10;
    private static final int minShipInQueue = 0;
    private int shipsCounter = 0;

    public ShipQueue(){
        this.shipQueue = new ArrayList<>();
    }

    // добавление корабля в очередь в док для загрузки/разгрузки
    public synchronized boolean addNewShip(Ship newShip){
        if (shipsCounter < maxShipInQueue){
            notifyAll();
            shipQueue.add(newShip);

            System.out.println("Прибыл новый корабль." + newShip.toString());
            shipsCounter++;
        }else {
            System.out.println("Очередь переполнена для прибывшего корабля " + newShip.toString());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }

        return true;
    }

    // получение коробля из очереди для загрузки/разгрузки
    public synchronized Ship getShip(){
        Ship ship;

        if (shipsCounter > minShipInQueue){
            notifyAll();
            ship = shipQueue.get(0);
            shipsCounter--;

            System.out.println(ship.getName() + " отправляется в док");
            shipQueue.remove(ship);
            return ship;
        }

        System.out.println("Новые корабли еще не пришли");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
