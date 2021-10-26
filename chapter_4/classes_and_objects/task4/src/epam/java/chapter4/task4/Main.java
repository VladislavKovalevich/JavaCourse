package epam.java.chapter4.task4;

import epam.java.chapter4.task4.action.TrainAction;
import epam.java.chapter4.task4.entity.Train;

import java.text.ParseException;
import java.util.Arrays;

/**
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления.
 */

public class Main {
    public static void main(String[] args) throws ParseException {
        Train[] trains = {
                new Train("Warszawa", 34, Train.getTimeFormat().parse("11:22")),
                new Train("Warszawa", 99, Train.getTimeFormat().parse("12:18")),
                new Train("Warszawa", 31, Train.getTimeFormat().parse("16:59")),
                new Train("Minsk", 51, Train.getTimeFormat().parse("10:32")),
                new Train("Minsk", 49, Train.getTimeFormat().parse("09:47")),
        };

        TrainAction trainAction = new TrainAction();

        Train[] trainsSortedByNumber;

        trainsSortedByNumber = trainAction.sortTrainArrayByNumber(trains);
        System.out.println(Arrays.toString(trainsSortedByNumber));

        Train[] trainsSortedByArrivalPoint;
        trainsSortedByArrivalPoint = trainAction.sortTrainArrayByArrivalPoint(trains);
        System.out.println(Arrays.toString(trainsSortedByArrivalPoint));

        StringBuilder stringBuilder;

        stringBuilder = trainAction.getInfoAboutTrainByNumber(trains, 34);
        System.out.println(stringBuilder.toString());

        stringBuilder = trainAction.getInfoAboutTrainByNumber(trains, 0);
        System.out.println(stringBuilder.toString());

    }
}
