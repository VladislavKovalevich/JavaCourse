package epam.java.chapter4.task3.entity;

public class Region {
    private String name;
    private City mainCity;
    private District[] districts;

    public Region(String name, City mainCity, District[] districts) {
        this.name = name;
        this.mainCity = mainCity;
        this.districts = districts;
    }

    public City getMainCity() {
        return mainCity;
    }

    public void setMainCity(City mainCity) {
        this.mainCity = mainCity;
    }

    public District[] getCities() {
        return districts;
    }

    public void setCities(District[] districts) {
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
