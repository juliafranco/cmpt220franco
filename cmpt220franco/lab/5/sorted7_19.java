import java.util.Scanner;

public class sorted7_19 {
	public static void main (String[] args){
		//prompt the user to input a list and display if it's sorted.
		Scanner input = new Scanner(System.in); // creates a new scanner object
		
		System.out.print("Enter list (first number is the number of elements) ");
		int l = input.nextInt(); //first number is the number of elements in the list and it doesn't count in calc.
		double[] numbers = new double [l]; 
		for (int i = 0; i < l; i++){
			numbers[i] = input.nextDouble();
		}
		if (isSorted(numbers) == true){ // JA: The comparison is not needed, just isSorted(numbers) returns a boolean
			System.out.println("The list is sorted.");
		} else if (isSorted(numbers) == false) {
			System.out.println("The list is not sorted.");
		}
	}
	public static boolean isSorted(double[] list){
		for (int i = 1; i < list.length; i++){ // JA: This index can only go to list.lenght - 1, because it would go outside the bounds
			if (list[i] > list[i + 1])
				return false; // JA: 
			break; // JA: This break is not needed here. It's making the program misbehave
		} 
		return true;
	}
}


