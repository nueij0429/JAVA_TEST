package workshop.account.test;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		//Account ��ü
		Account account = new Account("A1100","221-22-3477",100000);
		System.out.println(account);
		System.out.println("����ȣ: " + account.getCustId());
		System.out.println("���¹�ȣ: " + account.getAcctId());
		System.out.println("�ܾ�: " + account.getBalance());
	}
}
