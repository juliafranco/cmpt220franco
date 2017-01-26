package two;

import java.util.Scanner;

public class Vowel4_13 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		char ch = input.next().charAt(0);
		
		if (ch == 'a' || ch == 'A' ||  ch == 'e' ||  ch == 'E' || ch == 'i' || 
				ch == 'I' ||  ch == 'o' ||  ch == 'O' || ch == 'U' ||  ch == 'u' ){;
				System.out.println(ch + " is a vowel");
		} else {
			if ( ch >= 'A' && ch <= 'z'){
				System.out.println(ch + " is a consonate");
				} else {
					System.out.println(ch + " is an invalid input");
				}
		}
	}
}