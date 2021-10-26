package epam.java.chapter4.task5.action;

import epam.java.chapter4.task5.entity.DecimalCounter;

public class DecimalCounterAction {

    public DecimalCounterAction(){

    }

    public DecimalCounter incrementCounter(DecimalCounter counter){

        counter.setState(counter.getState() + 1);

        return counter;
    }

    public DecimalCounter decrementCounter(DecimalCounter counter){

        counter.setState(counter.getState() - 1);

        return counter;
    }

    public String getInfoAboutCounter(DecimalCounter counter){
        return counter.toString();
    }
}

