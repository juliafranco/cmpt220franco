import java.util.Scanner;

public class Factors5_16 {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		int startingnumber = number;
		
		String factors = "";
		int k = 2; //possible starting factor
		
		//find factors
		while ( number != 0 && k < startingnumber){
			int r = number % k;
			
			if (r == 0){
				factors += k + " ";
				number = number /k;
			}
			if (number % k == 0){
				continue;
				
			}
			k++;
		}
		
		//put them in order
		if (factors == ""){
			System.out.println(startingnumber + " has no factors besides one and itself.");
		} else {
			System.out.print("the factors of " + startingnumber + " are: " + factors);
			}
	}
}
