package epam.java.chapter5.task5.entity;

import java.util.Arrays;

public class Tour {
    private String country;
    private String city;
    private int days;
    private final double price;
    private TourType tourType;
    private Meal[] meals;
    private Transport transport;

    public Tour(String country, String city, int days, TourType tourType, Meal[] meals, Transport transport) {
        this.country = country;
        this.city = city;
        this.days = days;
        this.tourType = tourType;
        this.meals = meals;
        this.transport = transport;

        double price = days * (tourType.getPrice() + transport.getPrice());

        for (Meal m: meals) {
            price += days * m.getPrice();
        }

        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getPrice() {
        return price;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public Meal[] getMeals() {
        return meals;
    }

    public void setMeals(Meal[] meals) {
        this.meals = meals;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return country + " / " +
                city + " / " +
                days + " / " +
                price + " / " +
                tourType.toString() + " / " +
                Arrays.toString(meals) + " / " +
                transport.toString();
    }
}
