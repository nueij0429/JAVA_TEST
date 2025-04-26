package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;

public abstract class Account {
	private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    //���¹�ȣ
    public String getAccountNumber() {
        return accountNumber;
    }

    //������
    public String getOwnerName() {
        return ownerName;
    }

    //�ܾ�
    public double getBalance() {
        return balance;
    }

    // �Ա�
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("�Ա� �ݾ��� 0���� Ŀ�� �մϴ�.");
        }
    }

    // ���
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("��� �ݾ��� 0���� Ŀ�� �մϴ�.");
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�.");
        }
        balance -= amount;
    }

    // ���� ����
    @Override
    public String toString() {
    	return "���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance + "��";
    }
}
