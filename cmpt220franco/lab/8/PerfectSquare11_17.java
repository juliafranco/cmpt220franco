import java.util.ArrayList;
import java.util.Scanner;

public class PerfectSquare11_17 {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer m: ");
		int m = input.nextInt();
		int n = findN(findFactors(m));
		//insert method call
		System.out.println("The smallest number n for m * n to be a perfect square is " + n +
		"\nm * n is " + m * n);
	}
	/**method to find the perfect square*/
	public static int findN(ArrayList<Integer> factors){
		ArrayList<Integer> odds = new ArrayList<>();
		ArrayList<Integer> unique = new ArrayList<>();
		int n = 1;
		
		for(int i : factors)
			if(!unique.contains(i))
				unique.add(i);
		for(Integer i : unique)
			if(foundOddTimes(i, factors))
				odds.add(i);
		for(int i : odds)
			n *= i;
		return n;
	}
	
	public static boolean foundOddTimes(int i, ArrayList<Integer> factors) {
		int count = 0;
		for (int num : factors)
			if(i == num)
				count++;
		return count % 2 != 0 ? true : false;
}

	public static ArrayList<Integer> findFactors (int m){
		int startingnumber = m;
		int k = 2; //possible starting factor
		ArrayList<Integer> factors = new ArrayList<>();
		//find factors
		while ( m != 0 && k < startingnumber){	
			if (m % k == 0){
				factors.add(k); //saves k as a factor.
				m = m /k;
				continue;
				}
			k++;
			}
		return factors;

	}
}
