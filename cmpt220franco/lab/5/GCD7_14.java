import java.util.Scanner;

public class GCD7_14 {
	public static void main (String[] args){
		//prompt the user to enter 5 numbers, use method to find GCD and display it
		final int NUMBER_OF_ELEMENTS = 5;
		Scanner input = new Scanner(System.in); // creates a new scanner object
		int[] array = new int [NUMBER_OF_ELEMENTS]; //create an array of 10 numbers
		System.out.print("Enter " + NUMBER_OF_ELEMENTS + " numbers ");
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++){
			array[i] = input.nextInt();
		}
		int grcd = gcd (array);
		
		if (grcd == -1){
			System.out.println("No argument passed");
		} else {
			System.out.println("The greatest common denominator is " + grcd);
		}
	}
	public static int gcd (int... numbers){
		if (numbers.length == 0) {
			return -1;
			}
		int gcd = 1; // Initial gcd is 1
		int k = 2; // Possible gcd
		
		for (int i = 0; i < numbers.length; i++) {//i is the index of the number
			if ((i + 1) >= numbers.length){
				return gcd;
			} else {
				while (numbers[0] >= k){
					if (numbers[i] % k == 0 && numbers[i + 1] % k == 0)
						gcd = k; // Update gcd
				k++;  //go to the next GCD
				}
			}	
		}
		return gcd;
	}
}
