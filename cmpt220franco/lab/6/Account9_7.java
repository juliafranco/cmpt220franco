import java.util.Date;

public class Account9_7 {
	public static void main (String[] args){
		 Account account1 = new Account (1122, 20000);
		 account1.setAnnualInterestRate(4.2);
		 account1.withdraw(2500);
		 account1.deposit(3000);
		System.out.println("The balance of account " + account1.getId() + " is $" + account1.getBalance() + "."
				+ " The monthly interest is $" + account1.getMonthlyInterest() + " and it was created on "
				+ account1.getCreationDate());		 
	}
}
class Account{
	private int id =1;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new java.util.Date(); 
	
	/** Construct a default account*/
	Account(){
	}
	/**construct an account with specified id and balance*/
	Account( int newId, double newBalance ){
		id = newId;
		balance = newBalance;
	}
	
	/**getter method for id*/
	public int getId(){
		return id;
	}
	
	/**mutator method for id*/
	public void setId ( int newId){
		id = newId;
	}
	
	/**getter method for balance*/
	public double getBalance(){
		return balance;
	}
	
	/**mutator method for balance*/
	public void setBalance ( double newBalance){
		balance = newBalance;
	}
	
	/**getter method for interest rate*/
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	/**mutator method for interest rate*/
	public void setAnnualInterestRate ( double newAnnualInterestRate){
		annualInterestRate = newAnnualInterestRate;
	}
	
	/**getter method for creation date*/
	public Date getCreationDate(){
		return dateCreated;
	}
	
	/** returns monthly interest rate */
	public double getMonthlyInterestRate(){
		return (annualInterestRate /100)/12;
	}
	
	/**returns monthly interest */
	public double getMonthlyInterest(){
		return getMonthlyInterestRate() * balance;
	}

	/** takes out specified amount */
	public double withdraw ( double withdrawAmount){
		return balance -= withdrawAmount;
	}
	
	/** puts in a  specified amount */
	public double deposit ( double depositAmount){
		return balance += depositAmount;
	}
}
