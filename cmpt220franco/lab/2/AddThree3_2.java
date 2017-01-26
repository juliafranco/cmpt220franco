package two;

import java.util.Scanner;

public class AddThree3_2 {
	public static void main (String[] args) {
		int number1 = (int)(System.currentTimeMillis() % 10 );
		int number2 = (int)(System.currentTimeMillis() /7 % 10 );
		int number3 = (int)(System.currentTimeMillis() /4 % 10 );
		
		//Create Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.print("What is " + number1 + "+" + number2+  "+" + number3+ "?");
		
		int answer = input.nextInt();
		
		System.out.print(number1 + "+" + number2+ "+" + number3+ "=" + answer + " is " 
		+ (number1+ number2+number3 == answer));
	}


}
