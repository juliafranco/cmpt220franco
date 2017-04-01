//JA import Account;

public class TestAccount11_3 {
	public static void main (String[] args){
		 Account account1 = new Account (1122, 20000);
		 account1.setAnnualInterestRate(4.2);
		 System.out.println(account1.toString());
		 account1.withdraw(2500);
		 account1.deposit(3000);
		 System.out.println("After some activity, " + account1.toString());
		 System.out.println("");

		 CheckingAccount checking = new CheckingAccount(5, 235.18, .24, 250 );
		 System.out.println(checking.toString());
		 checking.withdraw(300);
		 System.out.println("After some activity, "+ checking.toString());
		 checking.deposit(144.32);
		 checking.withdraw(600);
		 System.out.println("After some activity, "+ checking.toString());
		 System.out.println("");

		 SavingsAccount savings = new SavingsAccount(45, 465, .24 );
		 System.out.println(savings.toString());
		 savings.withdraw(600);
		 savings.deposit(144.32);
		 savings.withdraw(600);
		 System.out.println("After some activity, "+ savings.toString());
	}
}
