package epam.java.chapter4.task4;

import epam.java.chapter4.task4.action.BankAccountBaseAction;
import epam.java.chapter4.task4.entity.Account;
import epam.java.chapter4.task4.entity.BankAccount;
import epam.java.chapter4.task4.entity.BankAccountsBase;
import epam.java.chapter4.task4.entity.Client;

import java.util.Arrays;

/**
 *Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
 *счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
 *всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount[] bankAccounts;
        BankAccountsBase bankAccountsBase;
        BankAccountBaseAction bankAccountBaseAction;

        bankAccounts = new BankAccount[]{
                new BankAccount(
                        new Client("Kowalewich", "Wladislaw", "Andreewich"),
                        new Account[]{
                                new Account(1001, 125.0), new Account(1981, 400.0)
                        }
                ),
                new BankAccount(
                        new Client("Igorev", "Andrey", "Mihailovich"),
                        new Account[]{
                                new Account(5431, -452.8), new Account(4512, 1000.0)
                        }
                ),
                new BankAccount(
                        new Client("Ivanov", "Ivan", "Ivanovich"),
                        new Account[]{
                                new Account(5567, 560.7), new Account(3341, -490.5)
                        }
                )
        };

        bankAccountsBase = new BankAccountsBase(bankAccounts);
        bankAccountBaseAction = new BankAccountBaseAction();

        BankAccount account;

        account = bankAccountBaseAction.searchAccountByNumber(bankAccountsBase, 1001);

        bankAccountBaseAction.lockAccount(bankAccountsBase, 3341);

        System.out.println(account.getClient().toString() + ": " + Arrays.toString(account.getAccounts()));

        bankAccountBaseAction.sortAccountsByNumber(bankAccountsBase);

        for (BankAccount b: bankAccountsBase.getBankAccounts()) {
            System.out.println("Счета клиента " + b.getClient().toString() + ":");
            for (Account a: b.getAccounts()) {
                System.out.println(a.getNumber() + "/" + a.getBalance() + "/" + a.isStatus());
            }
        }

        System.out.println("\n" + "Суммарное значение счетов:" + bankAccountBaseAction.getAllAccountsSum(bankAccountsBase));
        System.out.println("Сумма значения счетов с отрицательным балансом: " + bankAccountBaseAction.getAllNegativeAccountsSum(bankAccountsBase));
        System.out.println("Сумма значения счетов с положительным балансом: " + bankAccountBaseAction.getAllPositiveAccountsSum(bankAccountsBase));
    }
}
