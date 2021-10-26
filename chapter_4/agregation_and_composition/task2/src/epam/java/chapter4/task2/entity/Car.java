package epam.java.chapter4.task2.entity;

public class Car {
    private String model;
    private Engine engine;
    private Wheel[] wheels = new Wheel[4];
    private double currTankVolume;
    private double maxTankVolume;
    private double mileage;

    public Car(String type, Engine engine, Wheel[] wheels, double currTankVolume, double maxTankVolume) {
        this.model = type;
        this.engine = engine;
        this.wheels = wheels;
        this.currTankVolume = currTankVolume;
        this.maxTankVolume = maxTankVolume;
        this.mileage = 0.0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public double getMaxTankVolume() {
        return maxTankVolume;
    }

    public void setMaxTankVolume(double maxTankVolume) {
        this.maxTankVolume = maxTankVolume;
    }

    public double getCurrTankVolume() {
        return currTankVolume;
    }

    public void setCurrTankVolume(double currTankVolume) {
        this.currTankVolume = currTankVolume;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
