package epam.java.chapter5.task3;

import epam.java.chapter5.task3.entity.Calender;

/**
 * Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
 * выходных и праздничных днях.
 */
public class Main {
    public static void main(String[] args) {
        Calender calender;

        calender = new Calender(
                new Calender().new Day("Новый год", "01.01.2021"),
                new Calender().new Day("Международный женский день", "08.03.2021"),
                new Calender().new Day("День программиста", "13.09.2021")
        );

        System.out.println(calender);
    }
}
