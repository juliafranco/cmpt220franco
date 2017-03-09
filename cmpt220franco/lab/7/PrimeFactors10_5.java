import java.util.Scanner;

public class PrimeFactors10_5 {
	//(Displaying the prime factors) Write a program that prompts the user to 
		//enter a positive integer and displays all its smallest factors in decreasing order.
		//For example, if the integer is 120 , the smallest factors are displayed as 5 , 3 , 2 , 2 ,2 .
	//Use the StackOfIntegers class to store the factors (e.g., 2 , 2 , 2 , 3 , 5 ) and retrieve and 
		//display them in reverse order.

	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		int startingnumber = number;
		StackOfIntegers stack = new StackOfIntegers();
		
		int k = 2; //possible starting factor
		
		//find factors
		while ( number != 0 && k < startingnumber){	
			if (number % k == 0){
				stack.push(k); //saves k as a factor.
				number = number /k;
				continue;
			}
			k++;
		}
		//retrieve and display in reverse order. 
		System.out.print("The prime factorization of " + startingnumber + " is ");
		while (!stack.empty())
			System.out.print(stack.pop() + ", ");

	}
}


	
