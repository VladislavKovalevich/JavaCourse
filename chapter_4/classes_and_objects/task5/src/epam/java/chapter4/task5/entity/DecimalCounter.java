package epam.java.chapter4.task5.entity;

public class DecimalCounter {
    private int state;

    public DecimalCounter(){
        this.state = 0;
    }

    public DecimalCounter(int state){
        this.state = state;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (state > 9){
            this.state = 0;
        }else{
            if (state < 0){
                this.state = 9;
            }else{
                this.state = state;
            }
        }
    }

    @Override
    public String toString() {
        return "Значение счетчика: " + this.state;
    }
}
