import java.math.BigInteger;

public class fiveorsix10_21 {
	// Find the first ten numbers greater than Long.MAX_VALUE that are divisible by 5 or 6 .
	//Long.MAX_VALUE = 9,223,372,036,854,775,807 (9 QUINTILLION, 223 Quadrillion, 372 trillion, 36 million, 775 thousand, eight hundred seven.)
	
	public static void main (String[] args){
		System.out.print("The first 10 numbers divisible by 5 or 6 greater than " + Long.MAX_VALUE + " are \n");
		
		BigInteger five = new BigInteger ("5");
		BigInteger six = new BigInteger ("6");
		BigInteger number = new BigInteger ("9223372036854775807");
		int count = 0;
		final int NUMBERS_TO_PRINT = 10;
		while (count < NUMBERS_TO_PRINT){
			if (number.remainder(five).equals(BigInteger.ZERO) || number.remainder(six).equals(BigInteger.ZERO)){
				count++;
				if (count % 3 == 0)
				 System.out.print(number + ", \n");
				else
					System.out.print(number + ", ");
				 }
			      
			number = number.add(BigInteger.ONE);
		}
	}

}
