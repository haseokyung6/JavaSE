package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            System.out.println("=== 계좌 생성 ===");
            String ac1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
            Account account1 = bank.findAccount(ac1);
            System.out.println("Saving(저축) 계좌가 생성되었습니다: " + account1);

            String ac2 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
            Account account2 = bank.findAccount(ac2);
            System.out.println("체킹 계좌가 생성되었습니다: " + account2);

            String ac3 = bank.createSavingsAccount("이영희", 30000.0, 2.0);
            Account account3 = bank.findAccount(ac3);
            System.out.println("저축 계좌가 생성되었습니다: " + account3);
            System.out.println();

            bank.printAllAccounts();
            System.out.println();

            System.out.println("=== 입금/출금 테스트 ===");
            bank.deposit(ac1, 5000.0);
            bank.withdraw(ac2, 3000.0);
            System.out.println();

            System.out.println("=== 이자 적용 테스트 ===");
            SavingsAccount savings = (SavingsAccount) bank.findAccount(ac1);
            savings.applyInterest();
            System.out.println();

            System.out.println("=== 계좌 이체 테스트 ===");
            bank.transfer(ac3, ac2, 5000.0);
            System.out.println();

            bank.printAllAccounts();

            try {
                bank.withdraw(ac2, 6000.0);
            } catch (InsufficientBalanceException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

            try {
                bank.transfer(ac2, ac1, 7000.0);
            } catch (InsufficientBalanceException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

            try {
                bank.deposit("AC9999", 1000.0);
            } catch (AccountNotFoundException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}