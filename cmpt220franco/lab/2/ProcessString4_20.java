package two;

import java.util.Scanner;

public class ProcessString4_20 {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String myString = input.nextLine();
		
		//display lenght
		int stringLenght = myString.length();
		
		//display first character
		String fCh = myString.substring(0,1);
		
		System.out.println("The first character of \"" + myString + "\" is " + fCh + " and the lenght is " 
		+ stringLenght);
		
	}

}
