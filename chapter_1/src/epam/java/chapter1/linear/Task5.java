package epam.java.chapter1.linear;

/**
 * Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
 * данное значение длительности в часах, минутах и секундах в следующей форме:
 * ННч ММмин SSc.
 */
public class Task5 {
    public static void main(String[] args) {
        int seconds;

        int resHours;
        int resMinutes;
        int resSeconds;

        seconds = 9809;

        resHours = seconds / 3600;
        resMinutes = seconds % 3600 / 60;
        resSeconds = seconds % 3600 % 60;

        System.out.println(resHours + " ч. " + resMinutes + " мин. " + resSeconds + " сек.");
    }
}
