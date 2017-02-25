import java.util.Scanner;

public class sumbycolume8_1 {
	public static void main (String[] args){
		final int ROWS = 3;
		final int COLUMNS = 4;
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		double[][] matrix = new double[ROWS][COLUMNS];
		System.out.println("Enter a " + matrix.length + " by " + matrix[0].length + " matrix row by row ");
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = input.nextInt(); // JA: This should read double, not int
		for (int k = 0; k < matrix[0].length; k++){ //k is the column index
			double total = sumColumn (matrix, k);
			System.out.println("The sum of column " + (k + 1) + " is " + total);
		}
	}
	public static double sumColumn (double [][] m, int columnIndex){
		//find the total of each column.
			double total = 0;
			for ( int row = 0; row < m.length ; row++){
				total += m[row][columnIndex];
			}
			return total;
	}

}
