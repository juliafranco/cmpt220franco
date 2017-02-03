public class pentagonal6_1 {
	public static void main (String[] args){
		int NUMBER_OF_PENT = 50;
		
		System.out.println("The first " + NUMBER_OF_PENT + " pentagonal number are: \n" );
		//printPenNums (NUMBER_OF_PENT);
		
	//}
		//display the first 100, ten on a line
		//public static void printPenNums(int number_of_pent){
			final int NUMBER_PER_LINE = 10; //Displays 10 per line
			int count = 0; // Count the number of pentagonal numbers 
			int n = 1; //starting number to evaluate pentagonal numbers.
						
			//repeatedly find pentagonal numbers
			while (count < NUMBER_OF_PENT){
				//Print the number and increase the count
				int pent = getPentagonalNumber (n);
				count++; // increase the count
				if (count % NUMBER_PER_LINE == 0){
					//Print the number and go to the nexrt line
					System.out.printf("%-5s\n" , pent);
				} else {
					System.out.printf("%-5s" , pent);
				}
				//go to the next number
				n++;
			}
		}
		
	//calculates pentagonal number output
	public static int getPentagonalNumber(int n){
		//pentagonal number = n(3n-1)/2 
		int pent = n * (3 * n - 1) / 2;
		return pent;
	}
}
