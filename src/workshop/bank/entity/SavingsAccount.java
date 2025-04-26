package workshop.bank.entity;

public class SavingsAccount extends Account {
	
	private double interestRate;  //������

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    //���� ����
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    //���� ����
    @Override
    public String toString() {
        return super.toString() + ", ������: " + (interestRate * 100) + "%";
    }
}
