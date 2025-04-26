package workshop.bank.entity;

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
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("��� �ݾ��� �߸��Ǿ��ų� �ܾ��� �����մϴ�.");
        }
    }

    // ���� ����
    @Override
    public String toString() {
        return "���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance;
    }
}
