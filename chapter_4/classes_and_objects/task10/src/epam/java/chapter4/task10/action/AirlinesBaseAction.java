package epam.java.chapter4.task10.action;

import epam.java.chapter4.task10.entity.Airline;
import epam.java.chapter4.task10.entity.AirlineBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirlinesBaseAction {
    public AirlinesBaseAction(){

    }

    public List<Airline> searchAirlinesByArrivalPoint(AirlineBase airlineBase, String arrivalPoint){
        List<Airline> airlines = new ArrayList<>();

        for (Airline airline : airlineBase.getAirlines()) {

            if (airline.getArrivalPoint().compareTo(arrivalPoint) == 0){
                airlines.add(airline);
            }

        }

        return airlines;
    }

    public List<Airline> searchAirlinesByDay(AirlineBase airlineBase, String day){
        List<Airline> airlines = new ArrayList<>();
        String[] tempDays;

        for (Airline airline : airlineBase.getAirlines()) {

            tempDays = airline.getDays();

            for (String tmpDay : tempDays) {

                if (tmpDay.compareTo(day) == 0){
                    airlines.add(airline);
                    break;
                }

            }
        }

        return airlines;
    }

    public List<Airline> searchAirlinesByDayAndTime(AirlineBase airlineBase, String day, Date time){
        List<Airline> airlines = new ArrayList<>();

        for (Airline a : searchAirlinesByDay(airlineBase, day)) {

            if (a.getDepartureTime().getTime() > time.getTime()){
                airlines.add(a);
            }

        }

        return airlines;
    }
}