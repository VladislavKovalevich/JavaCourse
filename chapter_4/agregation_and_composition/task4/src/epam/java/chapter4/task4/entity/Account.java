package epam.java.chapter4.task4.entity;

public class Account {
    private int number;
    private double balance;
    private boolean status;

    public Account(int number, double balance) {
        this.number = number;
        this.balance = balance;
        this.status = true;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "\nnumber=" + number +
                ",\nbalance=" + balance +
                ",\nstatus=" + status +
                "}\n";
    }
}
