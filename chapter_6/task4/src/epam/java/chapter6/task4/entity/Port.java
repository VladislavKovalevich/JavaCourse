package epam.java.chapter6.task4.entity;

public class Port {
    private int cargoCount;

    private static Port instance;

    private Port(int cargoCount) {
        this.cargoCount = cargoCount;
    }

    public static Port getInstance() {
        if (instance == null){
            instance = new Port(20);
        }
        return instance;
    }

    public synchronized void addCargo(int cargoCount) {
        if (isStorageEmpty()){
            notifyAll();
        }
        this.cargoCount += cargoCount;
        System.out.println(Thread.currentThread().getName() + ": В порт доставлен " + cargoCount + " контейнер," + " всего контейнеров: " + this.cargoCount);
    }

    public synchronized void removeCargo(int cargoCount){
        while (isStorageEmpty()){
            try {
                System.out.println(Thread.currentThread().getName() + ": Запасы порта пусты. Ожидание доставки контейнеров в порт");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.cargoCount -= cargoCount;
        System.out.println(Thread.currentThread().getName() + ": Из порта забрали " + cargoCount + " контейнер," + " всего контейнеров: " + this.cargoCount);
    }

    private boolean isStorageEmpty(){
        if (this.cargoCount == 0){
            return true;
        }

        return false;
    }
}
