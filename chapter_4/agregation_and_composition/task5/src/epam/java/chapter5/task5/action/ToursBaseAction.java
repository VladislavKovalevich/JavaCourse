package epam.java.chapter5.task5.action;

import epam.java.chapter5.task5.entity.Tour;
import epam.java.chapter5.task5.entity.TourType;
import epam.java.chapter5.task5.entity.ToursBase;

import java.util.ArrayList;
import java.util.List;

public class ToursBaseAction {

    public ToursBaseAction(){
    }

    public List<Tour> searchTourByType(ToursBase toursBase, TourType tourType){
        List<Tour> tours = new ArrayList<>();

        for (Tour t : toursBase.getTours()) {
            if (t.getTourType().equals(tourType)){
                tours.add(t);
            }
        }

        return tours;
    }

    public Tour[] sortToursByPrice(ToursBase toursBase){
        Tour[] tours;

        tours = toursBase.getTours();

        for (int i = 0; i < tours.length - 1; i++) {

            for (int j = tours.length - 1; j > i; j--) {

                if (tours[j - 1].getPrice() > tours[j].getPrice()){
                    Tour tour;
                    tour = tours[j - 1];
                    tours[j - 1] = tours[j];
                    tours[j] = tour;
                }

            }

        }

        return tours;
    }
}
