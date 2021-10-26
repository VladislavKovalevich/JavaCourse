package epam.java.chapter4.task10.entity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Airline {
    private String arrivalPoint;
    private int number;
    private String airplaneType;
    private Date departureTime;
    private String[] days;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    public Airline(String arrivalPoint, int number, String airplaneType, Date departureTime, String[] days) {
        this.arrivalPoint = arrivalPoint;
        this.number = number;
        this.airplaneType = airplaneType;
        this.departureTime = departureTime;
        this.days = days;
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

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public static SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public static void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        Airline.simpleDateFormat = simpleDateFormat;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "\n arrivalPoint='" + arrivalPoint + '\'' +
                ",\n number=" + number +
                ",\n airplaneType=" + airplaneType +
                ",\n departureTime=" + departureTime +
                ",\n days=" + Arrays.toString(days) +
                "\n}\n";
    }
}
