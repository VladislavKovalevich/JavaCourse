package epam.java.chapter4.task1.action;

import epam.java.chapter4.task1.entity.Test1;

public class Test1Action {

    public Test1Action(){
    }

    public int getSum(Test1 test1){
        return test1.getX() + test1.getY();
    }

    public int getMaxValue(Test1 test1){
        return Math.max(test1.getX(), test1.getY());
    }
}
