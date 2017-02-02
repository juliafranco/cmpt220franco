import java.util.Scanner;

public class Palen6_3 {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		int reverse = reverse(number);
		boolean palindrome = isPalindrome(number, reverse);//calls isPalidrome method and saves it.
		
		System.out.print("The integer " + number + " is a " + palindrome + " palindrome: ");	
	}
		
		//Return the reversal of a integer, i. e. reverse 456 returns 654
		
	public static int reverse(int number){
		int reverse = 0;
		while (number != 0 ){
			reverse = reverse * 10;
			reverse = reverse + number % 10;
			number = number/10;
			} return reverse;
	}
		
		//return true is the number is a palindrome
		public static boolean isPalindrome(int number, int reverse){
			if (reverse == number)
				return true;
			return false;	
		}
}
