package epam.java.chapter4.task6;

import epam.java.chapter4.task6.action.TimeAction;
import epam.java.chapter4.task6.entity.Time;

/**
 * Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд.
 */
public class Main {
    public static void main(String[] args) {
        Time time;
        TimeAction timeAction;

        time = new Time(11, 23, 59);
        timeAction = new TimeAction();

        System.out.println("Начальное время: " + time.toString());

        timeAction.changeHours(time, 24);
        System.out.println("Изменение значения количества часов: " + time.toString());

        timeAction.changeHours(time, 14);
        System.out.println("Изменение значения количества часов: " + time.toString());

        timeAction.changeMinutes(time, -23);
        System.out.println("Изменение значения количества минут: " + time.toString());

        timeAction.changeMinutes(time, 56);
        System.out.println("Изменение значения количества минут: " + time.toString());

        timeAction.changeSeconds(time, 93);
        System.out.println("Изменение значения количества секунд: " + time.toString());

        timeAction.changeSeconds(time, 46);
        System.out.println("Изменение значения количества секунд: " + time.toString());

        System.out.println("Добавление часов (5):");
        timeAction.addHours(time, 5);
        System.out.println(time.toString());

        System.out.println("Добавление минут (545):");
        timeAction.addMinutes(time, 545);
        System.out.println(time.toString());

        System.out.println("Добалвние секунд (3734):");
        timeAction.addSeconds(time, 3734);
        System.out.println(time.toString());

    }
}
