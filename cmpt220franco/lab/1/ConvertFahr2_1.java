package one;

import java.util.Scanner;

public class ConvertFahr2_1 {
	public static void main (String[] args){
		//creates a Scanner object.
		Scanner input = new Scanner(System.in);
		
		//reads a double value from console
		System.out.print("Enter degrees Celsius to convert. ");
		double celsius = input.nextDouble();
		
		//converts to Fahrenheit (fahr)
		double fahr = ((9./5) * celsius + 32);
		
		//print result
		System.out.println (celsius + " Celsius is " + fahr +
				" Fahrenheit" );
	}

}
