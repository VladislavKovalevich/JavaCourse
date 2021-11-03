package epam.java.chapter5.task5;

import epam.java.chapter5.task5.action.ToursBaseAction;
import epam.java.chapter5.task5.entity.*;

import java.util.List;

/**
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 * различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
 * возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок
 */
public class Main {
    public static void main(String[] args) {
        Tour[] tours;
        ToursBase toursBase;
        ToursBaseAction toursBaseAction;

        tours = new Tour[]{
                new Tour("Греция", "Афины", 14, TourType.EXCURSION, new Meal[]{Meal.BREAKFAST, Meal.LUNCH}, Transport.BUS),
                new Tour("Греция", "Патры", 7, TourType.CRUISE, new Meal[]{Meal.BREAKFAST, Meal.LUNCH, Meal.DINNER}, Transport.SHIP),
                new Tour("Франция", "Париж", 10, TourType.SHOPPING, new Meal[]{Meal.BREAKFAST, Meal.LUNCH}, Transport.TRAIN),
                new Tour("Франция", "Сен-Кантен", 5, TourType.SHOPPING, new Meal[]{Meal.BREAKFAST, Meal.LUNCH}, Transport.BUS),
                new Tour("Великобритания", "Лондон", 17, TourType.RECREATION, new Meal[]{Meal.BREAKFAST, Meal.LUNCH}, Transport.TRAIN),
        };

        toursBase = new ToursBase("customTourOperator", tours);
        toursBaseAction = new ToursBaseAction();


        Tour tour[];

        tour = toursBaseAction.sortToursByPrice(toursBase);

        for (Tour t : tour) {
            System.out.println(t.toString());
        }

        List<Tour> tourList;

        tourList = toursBaseAction.searchTourByType(toursBase, TourType.SHOPPING);

        System.out.println();

        for (Tour t : tourList) {
            System.out.println(t.toString());
        }
    }
}
