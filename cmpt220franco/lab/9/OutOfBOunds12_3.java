import java.util.Scanner;

public class OutOfBOunds12_3 {
	public static void main (String[] args){
		//creates a list to randomly fill with numbers
		int[] numbers = new int[100];
		for (int i = 0; i < numbers.length; i++){
			numbers[i] = (int)(Math.random() * 100);
		}
		//gets input from the user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a value index between 0 and 99 ");
		int j = input.nextInt();
		
		try {
		System.out.println("The value at index " + j + " is " + numbers[j]); 
		}
		catch (ArrayIndexOutOfBoundsException ex){
			System.out.println("Out of Bounds.");
		}
	}
}
