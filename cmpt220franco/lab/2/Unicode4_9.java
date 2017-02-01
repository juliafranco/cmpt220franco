import java.util.Scanner;

public class Unicode4_9 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a character: ");
		char chInput = input.next().charAt(0);
		int ch = (int) chInput;

		System.out.print("The unicode for the character " + chInput + " is " 
		+ (int)ch);
		
	}

}
