package epam.java.chapter4.task4.entity;

public class BankAccountsBase {
    private BankAccount[] bankAccounts;

    public BankAccountsBase(BankAccount[] bankAccounts){
        this.bankAccounts = bankAccounts;
    }

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
