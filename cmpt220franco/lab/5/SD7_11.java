package five;

import java.util.Scanner;

public class SD7_11 {
	public static void main (String[] args){
		final int NUMBER_OF_ELEMENTS = 10;
		Scanner input = new Scanner(System.in); // creates a new scanner object
		double[] numbers = new double [NUMBER_OF_ELEMENTS]; //create an array of 10 numbers
		System.out.print("Enter " + NUMBER_OF_ELEMENTS + " numbers ");
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++){
			numbers[i] = input.nextDouble();
		}
		double mean = mean(numbers);
		double sd = deviation(numbers, mean);
		
		System.out.println("The mean is " + mean);
		System.out.println("The standard deviation is " + sd);
	}
	/**Compute the deviation of double values*/
	public static double deviation(double[] x , double mean){
		double devsum = 0;
		double sd = 0;
		for (int i = 0; i < x.length; i++){
			devsum += (Math.pow(( x[i] - mean), 2));
			 sd = Math.sqrt(devsum / (double)(x.length - 1));
		}
		return sd;
	}
	/**compute the mean of an array of double values*/
	public static double mean(double[] x){
		double sum = 0;
		for (int i = 0; i < x.length ; i++){
			sum += x[i];	
		}
		return (sum/x.length);

	}
}
