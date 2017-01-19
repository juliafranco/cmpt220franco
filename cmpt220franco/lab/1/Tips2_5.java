package one;

import java.util.Scanner;

public class Tips2_5 {
	public static void main(String[] args) {
		//Create scanner object
		Scanner input = new Scanner(System.in);
		
		//prompt the user to enter the subtotal and tip percentage
		System.out.print ("Enter the subtotal and tip rate. ");
		double subtotal = input.nextDouble();
		double tipRate = input.nextDouble();
		
		//compute tip amount
		double tipAmount = (tipRate / 100) * subtotal;
		
		//compute total 
		double total = tipAmount + subtotal;
		
		//display result
		System.out.println("The tip amount is $" + tipAmount + " and the total "
				+ "is $" + total );
	}

}
