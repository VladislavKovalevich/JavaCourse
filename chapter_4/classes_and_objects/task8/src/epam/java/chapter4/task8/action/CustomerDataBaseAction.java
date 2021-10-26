package epam.java.chapter4.task8.action;

import epam.java.chapter4.task8.entity.Customer;
import epam.java.chapter4.task8.entity.CustomerDataBase;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomerDataBaseAction {
    public CustomerDataBaseAction(){

    }

    public ArrayList<Customer> searchCustomersByCreditCardNumber(CustomerDataBase customerDataBase, long min, long max){
        ArrayList<Customer> customerList;

        customerList = new ArrayList<>();

        for (Customer customer: customerDataBase.getCustomers()) {
            if (customer.getCreditCardNumber() > min && customer.getCreditCardNumber() < max){
                customerList.add(customer);
            }
        }

        return customerList;
    }


    public void sortCustomersByName(CustomerDataBase customerDataBase){
        customerDataBase.getCustomers().sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                StringBuilder o1Name;
                StringBuilder o2Name;

                o1Name = new StringBuilder(o1.getSurname());
                o2Name = new StringBuilder(o2.getSurname());

                o1Name.append(o1.getName()).append(o1.getPatronymic());
                o2Name.append(o2.getName()).append(o2.getPatronymic());

                return o1Name.toString().compareTo(o2Name.toString());
            }
        });
    }
}
