import java.util.Scanner;

public class posneg5_1 {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer, the input ends if it is 0: ");
		int number = input.nextInt();
		
		int sum = 0;
		int countpos = 0;
		int countneg = 0;
		int count = 0;
		
		while (number != 0) {
			
			//find total
			sum += number;
			
			//stuff to find pos/neg
			if (number > 0){
				countpos++;
			} else {
				countneg++; 
			}
			
			//Read the next data
			System.out.println("Enter an integer (the input ends if it is 0");
			number = input.nextInt();
			count += 1;
		}
		if (count > 0){
			System.out.println("The number of positives is :" + countpos);
			System.out.println("The number of negatives is : " + countneg);
			System.out.println("The total is :" + sum);
			System.out.println("The average is : " + ((double) sum/count));
		} else {
			System.out.print("There are no inputs besides 0.");
		}
	}

}
