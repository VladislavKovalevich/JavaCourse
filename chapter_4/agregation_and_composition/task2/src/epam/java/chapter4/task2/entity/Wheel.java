package epam.java.chapter4.task2.entity;

public class Wheel {
    private double width;
    private double diameter;
    private String manufacturerBrand;

    public Wheel(double width, double diameter, String manufacturerBrand) {
        this.width = width;
        this.diameter = diameter;
        this.manufacturerBrand = manufacturerBrand;
    }


    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getManufacturerBrand() {
        return manufacturerBrand;
    }

    public void setManufacturerBrand(String manufacturerBrand) {
        this.manufacturerBrand = manufacturerBrand;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "\nwidth=" + width +
                ",\ndiameter=" + diameter +
                ",\nmanufacturerBrand='" + manufacturerBrand + '\'' +
                "}\n\n";
    }
}
