package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	public Account() {
		System.out.println(this.getClass().getName() + " 기본 생성자 호출");
	}
	// Constructor Overloading
	// 상단 메뉴바  Source>Generate Constructor using Fields
	public Account(String custId, String acctId) {
		super();
		this.custId = custId;
		this.acctId = acctId;
	}

//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	// setaccid 적고 ctrl+space bar
	public void setAcctId(String acctId) {
		this.acctId = acctId;

	}
	public void setCustId(String custId) {
		this.custId = custId;
	}

	//getter method
	public String getCustId() {
		return custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public int getBalance() {
		return balance;
	}
	
	// 입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	// 출금
	public void withdraw(int amount) {
		if(amount > balance) {
			System.out.println("잔액 부족");
		}
		this.balance -= amount;
	}
	
	// 메서드 재정의_Overriding  Source>Generate toStirng()
	@Override
	public String toString() {
		return "Account [고객번호=" + custId + ", 계좌번호=" + acctId + ", 잔액=" + balance + "]";
	}
	
	
	
	
}
