package epam.java.chapter4.task4.action;

import epam.java.chapter4.task4.entity.Account;
import epam.java.chapter4.task4.entity.BankAccount;
import epam.java.chapter4.task4.entity.BankAccountsBase;

public class BankAccountBaseAction {
    public BankAccountBaseAction() {

    }

    public void lockAccount(BankAccountsBase bankAccountsBase, int accountNumber){
        for (BankAccount b: bankAccountsBase.getBankAccounts()) {

            for (Account a: b.getAccounts()) {

                if (a.getNumber() == accountNumber){
                    a.setStatus(false);
                    break;
                }

            }

        }
    }

    public void unlockAccount(BankAccountsBase bankAccountsBase, int accountNumber){
        for (BankAccount b: bankAccountsBase.getBankAccounts()) {

            for (Account a: b.getAccounts()) {

                if (a.getNumber() == accountNumber){
                    a.setStatus(true);
                    break;
                }

            }

        }
    }

    public BankAccount searchAccountByNumber(BankAccountsBase bankAccountsBase, int accountNumber){
        BankAccount tempAccount = new BankAccount();

        for (BankAccount b: bankAccountsBase.getBankAccounts()) {

            for (Account a: b.getAccounts()) {

                if (a.getNumber() == accountNumber){

                    Account[] accounts = new Account[]{
                            new Account(a.getNumber(), a.getBalance())
                    };

                    tempAccount.setAccounts(accounts);
                    tempAccount.setClient(b.getClient());
                    tempAccount.setId(b.getId());

                    break;
                }

            }

        }

        return tempAccount;
    }

    public void sortAccountsByNumber(BankAccountsBase bankAccountsBase){

        for (BankAccount b : bankAccountsBase.getBankAccounts()) {

            Account[] tempAccounts;

            tempAccounts = sort(b.getAccounts());

            b.setAccounts(tempAccounts);

        }

    }

    private Account[] sort(Account[] tempAccounts) {

        for (int i = 0; i < tempAccounts.length - 1; i++) {

            for (int j = tempAccounts.length - 1; j > i; j--) {

                if (tempAccounts[j - 1].getNumber() > tempAccounts[j].getNumber()){

                    Account temp;
                    temp = tempAccounts[j - 1];
                    tempAccounts[j - 1] = tempAccounts[j];
                    tempAccounts[j] = temp;

                }

            }

        }

        return tempAccounts;
    }

    public double getAllAccountsSum(BankAccountsBase bankAccountsBase){
        double sum = 0.0;

        for (BankAccount b : bankAccountsBase.getBankAccounts()) {

            for (Account a: b.getAccounts()) {
                sum += a.getBalance();
            }

        }

        return sum;
    }

    public double getAllPositiveAccountsSum(BankAccountsBase bankAccountsBase){
        double sum = 0.0;
        double tempBalance = 0.0;

        for (BankAccount b : bankAccountsBase.getBankAccounts()) {

            for (Account a: b.getAccounts()) {

                tempBalance = a.getBalance();

                if (tempBalance >= 0) {
                    sum += a.getBalance();
                }
            }

        }

        return sum;
    }

    public double getAllNegativeAccountsSum(BankAccountsBase bankAccountsBase){
        double sum = 0.0;
        double tempBalance = 0.0;

        for (BankAccount b : bankAccountsBase.getBankAccounts()) {

            for (Account a: b.getAccounts()) {

                tempBalance = a.getBalance();

                if (tempBalance < 0) {
                    sum += a.getBalance();
                }
            }

        }

        return sum;
    }
}
