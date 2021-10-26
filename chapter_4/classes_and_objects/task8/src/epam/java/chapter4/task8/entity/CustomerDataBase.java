package epam.java.chapter4.task8.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerDataBase {
    private ArrayList<Customer> customers;

    public CustomerDataBase(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomerDataBase{" +
                "customers=" + Arrays.toString(customers.toArray()) +
                '}';
    }
}
