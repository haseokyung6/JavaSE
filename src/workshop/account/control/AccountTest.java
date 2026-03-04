package workshop.account.control;
import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		
		Account account = new Account();
	
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
				
		System.out.println("고객번호 : " + account.getCustId());
		System.out.println("계좌번호 : " + account.getAcctId());
		System.out.println("금액 :" + account.getBalance());
		
		Account account2 = new Account("A1200", "321-22-3477");
		account2.deposit(15000);
		account2.withdraw(10000);
		
		System.out.println(account2);
		System.out.println(account2.toString());
	}
}
