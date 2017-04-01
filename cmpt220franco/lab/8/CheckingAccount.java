//JA import Account;
public class CheckingAccount extends Account {
	private int id = 1;
	private double balance = 0;
	private double annualInterestRate = 0;
	private double overdraftLimit;

	/**no args constuctor*/
	public CheckingAccount(){
		
	}
	/**"main" constructor*/
	public CheckingAccount(double b, double interest, double overdraft){
		balance = b;
		annualInterestRate = interest;
		overdraftLimit = overdraft;
	}
	/**constructor to add ID*/
	public CheckingAccount( int idnumber, double b, double interest, double overdraft){
		balance = b;
		annualInterestRate = interest;
		id = idnumber;
		overdraftLimit = overdraft;
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
	/**takes money out of the account*/
	public double withdraw(double w){
		if (w > this.balance +this.overdraftLimit){
			//looks to see if taking out that amount of money will go over the overdraft limit 
			System.out.println("You don't have enough money to withdraw " + w);
			return this.balance;}
		return this.balance -= w;
	}
	/**adds money to account*/
	public double deposit(double d){
		return this.balance += d;
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
	
	/**prints out a string description of the account class*/
	public String toString (){
		return "The checking account " + id + " has a balance of $" + balance + "."
				+ " The monthly interest is $" + (annualInterestRate /100)/12 
                + " and it was created on "	+ getDateCreated();
	}
	
}
