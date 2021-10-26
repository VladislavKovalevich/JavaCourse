package epam.java.chapter5.task3.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calender {
    private Day[] days;

    public Calender(Day ...days){
        this.days = days;
    }

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Day day: days){
            stringBuilder.append(day).append("\n");
        }

        return stringBuilder.toString();
    }

    public class Day{
        private String name;
        private Date date;

        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        public Day(String name, String date) {
            try {
                this.date = simpleDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return date + " - " + name;
        }
    }
}
