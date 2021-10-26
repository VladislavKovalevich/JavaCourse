package epam.java.chapter4.task3.entity;

public class Country {
    private String name;
    private City capital;
    private Region[] regions;
    private double square;

    public Country(String name, City capital, Region[] regions, double square) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
