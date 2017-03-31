package nine;

import java.util.Scanner;

public class NumberFormat12_7 {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a binary number: ");
		String binary = input.next();
		try {
			System.out.println(binary + " as a decimal is equal to " + bin2Dec(binary) );
		} catch (NumberFormatException ex){
			System.out.println(ex);
		}
	}
	
	static int bin2Dec(String binaryString) throws NumberFormatException{
		if (!isBinary(binaryString))
			throw new NumberFormatException(binaryString + " is not a binary number.");
		int power = 0;
		int decimal = 0;
		for (int i = binaryString.length() - 1; i >= 0; i--) {
			if (binaryString.charAt(i) == '1') {
				decimal += Math.pow(2, power);}
			power++;}
		return decimal;
		}
	public static boolean isBinary(String binary) {
		for (char ch : binary.toCharArray())
			if (ch != '1' && ch != '0') return false;
		return true;
		}
	}
