package epam.java.chapter6.task4.entity;

public class PortCargoThread implements Runnable {
    private Port port;// = new Port();

    public PortCargoThread(Port port){
        this.port = port;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().setName("PortThread");
                Thread.sleep(100);
                port.addCargo(10);
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
