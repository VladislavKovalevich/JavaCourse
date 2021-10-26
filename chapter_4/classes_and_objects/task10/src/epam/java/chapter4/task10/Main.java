package epam.java.chapter4.task10;

import epam.java.chapter4.task10.action.AirlinesBaseAction;
import epam.java.chapter4.task10.entity.Airline;
import epam.java.chapter4.task10.entity.AirlineBase;

import java.text.ParseException;
import java.util.Date;

/**
 *  Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Airline[] airlines;
        AirlineBase airlineBase;
        AirlinesBaseAction airlinesBaseAction;

        airlines = new Airline[]{
                new Airline("Tokyo", 231, "Boeing 737", Airline.getSimpleDateFormat().parse("11:22"), new String[]{"Monday", "Tuesday", "Thursday"}),
                new Airline("Paris", 299, "Boeing 737", Airline.getSimpleDateFormat().parse("22:20"), new String[]{"Monday", "Wednesday", "Sunday"}),
                new Airline("Berlin", 756, "Boeing 767", Airline.getSimpleDateFormat().parse("13:40"), new String[]{"Wednesday", "Friday", "Saturday"}),
                new Airline("Kyoto", 131, "Boeing 353", Airline.getSimpleDateFormat().parse("15:10"), new String[]{"Monday", "Tuesday", "Saturday"}),
                new Airline("Berlin", 989, "Boeing 737", Airline.getSimpleDateFormat().parse("19:50"), new String[]{"Tuesday", "Thursday", "Sunday"}),
                new Airline("London", 608, "Boeing 858", Airline.getSimpleDateFormat().parse("16:25"), new String[]{"Monday", "Tuesday", "Friday"}),
                new Airline("London", 541, "Boeing 868", Airline.getSimpleDateFormat().parse("18:35"), new String[]{"Monday", "Wednesday", "Saturday"}),
                new Airline("London", 154, "Boeing 700", Airline.getSimpleDateFormat().parse("09:05"), new String[]{"Monday", "Tuesday", "Saturday"})
        };

        airlineBase = new AirlineBase(airlines);
        airlinesBaseAction = new AirlinesBaseAction();

        String arrivalPoint = "London";
        String day = "Monday";
        Date time = Airline.getSimpleDateFormat().parse("14:00");

        System.out.println("--------Рейсы до " + arrivalPoint + "---------");

        for (Airline a : airlinesBaseAction.searchAirlinesByArrivalPoint(airlineBase, arrivalPoint)){
            System.out.println(a.toString());
        }

        System.out.println("--------Рейсы для дня недели " + day + "---------");

        for (Airline a : airlinesBaseAction.searchAirlinesByDay(airlineBase, day)){
            System.out.println(a.toString());
        }

        System.out.println("--------Рейсы для дня недели " + day + " , вылетающие раньше "+ time.toString() + "---------");

        for (Airline a : airlinesBaseAction.searchAirlinesByDayAndTime(airlineBase, day, time)){
            System.out.println(a.toString());
        }
    }
}