package two;

import java.util.Scanner;

public class Days3_5 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter today's day: ");
		int currDay = input.nextInt();
		System.out.print("Enter the days elasped since today: ");
		int forwardDay = input.nextInt();
		
		System.out.print("Today is ");
		switch (currDay % 7) {
		case 0: System.out.print("Sunday"); break;
		case 1: System.out.print("Monday"); break;
		case 2: System.out.print("Tuesday"); break;
		case 3: System.out.print("Wednesday"); break;
		case 4: System.out.print("Thursday"); break;
		case 5: System.out.print("Friday"); break;
		case 6: System.out.print("Saturday"); break;
		}
		
		int futureDay = currDay + forwardDay;
		
		System.out.print(" and the future day is ");
		switch (futureDay % 7) {
		case 0: System.out.print("Sunday"); break;
		case 1: System.out.print("Monday"); break;
		case 2: System.out.print("Tuesday"); break;
		case 3: System.out.print("Wednesday"); break;
		case 4: System.out.print("Thursday"); break;
		case 5: System.out.print("Friday"); break;
		case 6: System.out.print("Saturday"); break;
		}

	}

}
