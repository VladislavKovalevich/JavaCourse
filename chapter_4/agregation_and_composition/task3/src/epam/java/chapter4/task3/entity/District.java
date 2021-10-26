package epam.java.chapter4.task3.entity;

public class District {
    private City mainCity;

    public District(City mainCity) {
        this.mainCity = mainCity;
    }

    public City getMainCity() {
        return mainCity;
    }

    public void setMainCity(City mainCity) {
        this.mainCity = mainCity;
    }
}
