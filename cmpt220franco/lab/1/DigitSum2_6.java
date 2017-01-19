package one;

import java.util.Scanner;

public class DigitSum2_6 {
	public static void main(String[] args) {
		
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//prompt the user to enter a number.
		System.out.print("Enter a number between 0 and 1000. ");
		int number = input.nextInt();
		
		//extract ones digit
		int ones = number % 10;
				
		//extract tens digit
		int tensExtract = number / 10;
		int tens = tensExtract % 10;
		
		//extract hundreds digit
		int hundredsExtract = tensExtract / 10;
		int hundreds = hundredsExtract % 10;
		
		//add them up
		int digitSum = (hundreds + tens + ones);
				
		//print the result
		System.out.println ("The sum of the digits is " + digitSum );
		System.out.println(hundreds);
		System.out.println(tens);
		System.out.println(ones);
	}

}
