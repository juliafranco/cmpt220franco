//JA import Account;
public class SavingsAccount extends Account {
	private int id = 1;
	private double balance = 0;
	private double annualInterestRate = 0;

	/**no args constuctor*/
	public SavingsAccount(){
		
	}
	/**"main" constructor*/
	public SavingsAccount(double b, double interest){
		balance = b;
		annualInterestRate = interest;
	}
	/**constructor to add ID*/
	public SavingsAccount( int idnumber, double b, double interest){
		balance = b;
		annualInterestRate = interest;
		id = idnumber;
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
		if (w > this.balance){//prevents account from being overdrawn
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
		return "The savings account " + id + " has a balance of $" + balance + "."
				+ " The monthly interest is $" + (annualInterestRate /100)/12 
                + " and it was created on "	+ getDateCreated();
	}
	
}
