package epam.java.chapter4.task2.entity;

public class Engine {
    private String manufacturerBrand;
    private String version;
    private int power;
    private double fuelConsumption;
    private int torque;

    public Engine(String manufacturerBrand, String version, int power, double fuelConsumption, int torque) {
        this.manufacturerBrand = manufacturerBrand;
        this.version = version;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.torque = torque;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getManufacturerBrand() {
        return manufacturerBrand;
    }

    public void setManufacturerBrand(String manufacturerBrand) {
        this.manufacturerBrand = manufacturerBrand;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "\nmanufacturerBrand='" + manufacturerBrand + '\'' +
                ",\n version='" + version + '\'' +
                ",\n power=" + power +
                ",\n fuelConsumption=" + fuelConsumption +
                ",\n torque=" + torque +
                "}\n\n";
    }
}
