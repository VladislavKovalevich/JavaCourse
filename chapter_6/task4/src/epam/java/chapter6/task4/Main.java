package epam.java.chapter6.task4;


import epam.java.chapter6.task4.entity.Dock;
import epam.java.chapter6.task4.entity.Port;
import epam.java.chapter6.task4.entity.PortCargoThread;
import epam.java.chapter6.task4.entity.ship.ShipGenerator;
import epam.java.chapter6.task4.entity.ship.ShipQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ShipQueue shipQueue = new ShipQueue();

        ShipGenerator shipGenerator = new ShipGenerator(shipQueue, 15);
        Port port = Port.getInstance();
        PortCargoThread portCargoThread = new PortCargoThread(port);

        Dock[] docks = new Dock[3];

        for (int i = 0; i < docks.length; i++) {
            docks[i] = new Dock(shipQueue, i, port);
        }

        ExecutorService service = Executors.newFixedThreadPool(5);

        service.execute(shipGenerator);

        for (int i = 0; i < docks.length; i++) {
            service.execute(docks[i]);
        }

        service.execute(portCargoThread);

        service.shutdown();
    }
}
