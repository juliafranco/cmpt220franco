import java.util.Scanner;

public class IndexofMin7_10 {
	public static void main (String[] args){
		final int NUMBER_OF_ELEMENTS = 10;
		Scanner input = new Scanner(System.in); // creates a new scanner object
		double[] numbers = new double [NUMBER_OF_ELEMENTS]; //create an array of 10 numbers
		System.out.print("Enter " + NUMBER_OF_ELEMENTS + " numbers ");
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++){
			numbers[i] = input.nextDouble();
		}
		
		int minIndex = indexOfSmallestElement(numbers);
		if (minIndex == -1){ //since the specified input is 10, this isn't needed. Useful for variable input.
			System.out.print("There is only one element in the list.");
		}
		else {
			System.out.print("The smallest number is in position " + (minIndex + 1));
		}
	}
	public static int indexOfSmallestElement(double[] array){
		//loop through elements to find the smallest value. 
		//if there's only one element, break out, return -1
		int i = 0;
		double currentMin = array[i];
		int currentMinIndex = i;
		if (array.length == 1){
			return -1;
		} else {
			for ( i = 0; i < array.length; i++){
				//find the smallest element of the list.
				for (int j = i + 1; j < array.length; j++){
					if (currentMin > array[j]) {
						currentMin = array[j];
						currentMinIndex= j;
					}
				}
			}
		}
		return currentMinIndex;
	}
}
