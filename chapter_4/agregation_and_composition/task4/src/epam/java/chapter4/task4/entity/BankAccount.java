package epam.java.chapter4.task4.entity;

import java.util.Arrays;

public class BankAccount {
    private static int bankAccountID = 1;
    private int id;
    private Client client;
    private Account[] accounts;

    public BankAccount(Client client, Account[] accounts) {
        this.id = bankAccountID++;
        this.client = client;
        this.accounts = accounts;
    }

    public BankAccount(){

    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankAccount{\n" +
                "\nid=" + id +
                ",\n client=" + client.toString() +
                ",\n accounts=" + Arrays.toString(accounts) +
                "}\n\n";
    }
}
