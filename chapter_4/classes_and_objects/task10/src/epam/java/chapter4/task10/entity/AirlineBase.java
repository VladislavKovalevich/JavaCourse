package epam.java.chapter4.task10.entity;

public class AirlineBase {
    private Airline[] airlines;

    public AirlineBase(Airline[] airlines) {
        this.airlines = airlines;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public void setAirlines(Airline[] airlines) {
        this.airlines = airlines;
    }
}
