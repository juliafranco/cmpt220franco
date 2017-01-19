package one;

import java.util.Scanner;

public class accel2_9 {
	public static void main (String[] args) {
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//prompt the user to enter v0 v1 and time
		System.out.print("Enter v0, v1, and time. ");
		int v0 = input.nextInt();
		int v1 = input.nextInt();
		int time = input.nextInt();
		
		//do the math
		int accel = (v1 - v0)/ time;
		
		//display results
		System.out.println("The average acceleration is " + accel);
	}
}
