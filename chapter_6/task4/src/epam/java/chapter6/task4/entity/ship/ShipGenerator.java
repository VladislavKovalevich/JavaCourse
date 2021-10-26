package epam.java.chapter6.task4.entity.ship;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private ShipQueue shipQueue;
    private int shipCount;

    public ShipGenerator(ShipQueue shipQueue, int shipCount) {
        this.shipQueue = shipQueue;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count = 0;
        ShipSize shipSize;
        Ship ship;

        while (count < shipCount){
            Thread.currentThread().setName("Ship-generator");

            count++;

            shipSize = getRandomSize();
            ship = new Ship(getName(count), shipSize, getRandomMode(), getRandomCargoNumber(shipSize.getSize()));

            shipQueue.addNewShip(ship);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getName(int count) {
        return "Ship-" + count;
    }

    private ShipSize getRandomSize() {
        Random random = new Random();
        return ShipSize.values()[random.nextInt(ShipSize.values().length)];
    }

    private boolean getRandomMode(){
        Random random = new Random();
        boolean[] b = {false, true};

        return b[random.nextInt(b.length)];
    }

    private int getRandomCargoNumber(int shipSize){
        Random random = new Random();
        return random.nextInt(shipSize - 1);
    }
}
