package epam.java.chapter5.task5.entity;

import java.util.Arrays;

public class ToursBase {
    private String tourOperatorName;
    private Tour[] tours;

    public ToursBase(String tourOperatorName, Tour[] tours) {
        this.tourOperatorName = tourOperatorName;
        this.tours = tours;
    }

    public String getTourOperatorName() {
        return tourOperatorName;
    }

    public void setTourOperatorName(String tourOperatorName) {
        this.tourOperatorName = tourOperatorName;
    }

    public Tour[] getTours() {
        return tours;
    }

    public void setTours(Tour[] tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "ToursBase{" +
                "tourOperatorName='" + tourOperatorName + '\'' +
                ", tours=" + Arrays.toString(tours) +
                '}';
    }
}
