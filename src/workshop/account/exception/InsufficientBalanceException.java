package workshop.account.exception;

public class InsufficientBalanceException extends Exception{
	
	public InsufficientBalanceException(String errMessage) {
		//�θ��� �����ڸ� ȣ��
		super(errMessage);
	}
}
