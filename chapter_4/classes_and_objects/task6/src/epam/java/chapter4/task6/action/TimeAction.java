package epam.java.chapter4.task6.action;

import epam.java.chapter4.task6.entity.Time;

public class TimeAction {
    public TimeAction(){

    }

    public void changeHours(Time time, int hours){
        time.setHours(hours);
    }

    public void changeMinutes(Time time, int minutes){
        time.setMinutes(minutes);
    }

    public void changeSeconds(Time time, int seconds){
        time.setSeconds(seconds);
    }

    public void addHours(Time time, int hours){
        if (hours <= 0){
            time.setHours(0);
        }else {
            time.setHours((time.getHours() + hours) % 24);
        }
    }

    public void addMinutes(Time time, int minutes){
        int allMinutes;

        if (minutes <= 0){
            time.setMinutes(0);
        }else{
            allMinutes = time.getHours() * 60 + time.getMinutes() + minutes;
            time.setMinutes(allMinutes % 60);
            time.setHours(((allMinutes - (allMinutes % 60)) / 60) % 24);
        }
    }

    public void addSeconds(Time time, int seconds){
        int allSeconds;

        if (seconds <= 0){
            time.setSeconds(0);
        }else{
            allSeconds = time.getHours()*3600 + time.getMinutes() * 60 + time.getSeconds() + seconds;

            time.setHours(((allSeconds - (allSeconds % 3600)) / 3600) % 24);
            time.setMinutes(((allSeconds % 3600 - ((allSeconds % 3600) % 60)) / 60) % 60);
            time.setSeconds((allSeconds % 3600) % 60);
        }
    }
}
