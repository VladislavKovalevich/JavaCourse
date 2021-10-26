package epam.java.chapter4.task4.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {
    private String arrivalPoint;
    private int number;
    private Date departureDate;
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public Train(String arrivalPoint, int number, Date departureDate) {
        this.arrivalPoint = arrivalPoint;
        this.number = number;
        this.departureDate = departureDate;
    }

    public static SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Train{" +
                "arrivalPoint='" + arrivalPoint + '\'' +
                ", number=" + number +
                ", departureDate=" + departureDate +
                '}'+ "\n";
    }
}
