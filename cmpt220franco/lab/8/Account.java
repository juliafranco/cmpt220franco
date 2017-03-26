import java.util.Date;

public class Account {
//	public static void main (String[] args){
//		 Account account1 = new Account (1122, 20000);
//		 account1.setAnnualInterestRate(4.2);
//		 account1.withdraw(2500);
//		 account1.deposit(3000);
//		System.out.println("The balance of account " + account1.getId() + " is $" + account1.getBalance() + "."
//				+ " The monthly interest is $" + account1.getMonthlyInterest() + " and it was created on "
//				+ account1.getCreationDate());		 
//	}
//}
//class Account{
	private int id =1;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new java.util.Date(); 
	
	/** Construct a default account*/
	public Account(){
	}
	/**construct an account with specified id and balance*/
	public Account( int newId, double newBalance ){
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
	/** getter method for monthly interest rate */
	public double getMonthlyInterestRate(){
		return (annualInterestRate /100)/12;
	}
	/**returns monthly interest amount */
	public double getMonthlyInterest(){
		return getMonthlyInterestRate() * balance;
	}
	
	/**getter method for creation date*/
	public Date getDateCreated() {
		return dateCreated;
	}

	/** takes out specified amount */
	public double withdraw ( double withdrawAmount){
		return balance -= withdrawAmount;
	}
	
	/** puts in a  specified amount */
	public double deposit ( double depositAmount){
		return balance += depositAmount;
	}
	/**prints out a string description of the account class*/
	public String toString (){
		return "The account " + id + " has a balance of $" + balance + "."
				+ " The monthly interest is $" + (annualInterestRate /100)/12 
                + " and it was created on "	+ getDateCreated();
	}

}
