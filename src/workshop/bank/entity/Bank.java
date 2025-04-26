package workshop.bank.entity;

import workshop.bank.exception.AccountNotFoundException;
import workshop.bank.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    public void createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("���� ���°� �����Ǿ����ϴ�: " + account);
    }

    public void createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + account);
    }

    private Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
        System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + account.getBalance() + "��");
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        try {
            account.withdraw(amount);
            System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + account.getBalance() + "��");
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }

    public void applyInterest(String accountNumber) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        if (account instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) account;
            double before = sa.getBalance();
            sa.applyInterest();
            double interest = sa.getBalance() - before;
            System.out.println(interest + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + sa.getBalance() + "��");
            System.out.println("���� " + interest + "���� ����Ǿ����ϴ�. ���� �ܾ�: " + sa.getBalance() + "��");
        } else {
            System.out.println("���� �߻�: ���� ���°� �ƴմϴ�.");
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException {
        Account from = findAccount(fromAccountNumber);
        Account to = findAccount(toAccountNumber);
        try {
            from.withdraw(amount);
            System.out.println(amount + "���� ��ݵǾ����ϴ�." + "���� �ܾ�: " + from.getBalance() + "��");
            to.deposit(amount);
            System.out.println(amount + "���� �ԱݵǾ����ϴ�." + "���� �ܾ�: " + to.getBalance() + "��");
            System.out.println(amount + "���� " + fromAccountNumber + "���� " + toAccountNumber + "�� �۱ݵǾ����ϴ�.");
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }

    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
