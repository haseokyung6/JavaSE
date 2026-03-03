package workshop.account.control;
import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		//Account °´Ã¼»ı¼º
		Account account = new Account();
		//°í°´¹øÈ£ : A1100, °èÁÂ¹øÈ£ : 221-22-3477, ÀÜ¾× : 100000
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
				
		System.out.println("°í°´¹øÈ£ : " + account.getCustId());
		System.out.println("°èÁÂ¹øÈ£ : " + account.getAcctId());
		System.out.println("ÀÜ¾× :" + account.getBalance());
		
		Account account2 = new Account("A1200", "321-22-3477");
		account2.deposit(15000);
		account2.withdraw(10000);
		
		System.out.println(account2);
		System.out.println(account2.toString());
	}
}
