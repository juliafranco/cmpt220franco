import java.util.Scanner;

public class Location9_13 {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
				
		//prompt the user to imput the dimension and the array. 
		System.out.print ("Enter the number of rows and columns in the array: ");
		int numberOfRows = input.nextInt();
		int numberOfColumns = input.nextInt();
		double[][] matrix = new double [numberOfRows][numberOfColumns];
		System.out.print ("Enter the array: ");
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = input.nextDouble();
                //display the largest element and its location. 
		Location maxLocation = locateLargest (matrix);
		System.out.print ("The location of the largest element (" + maxLocation.maxValue + ") is (" + 
				maxLocation.row + ", " + maxLocation.column + ")." );
		
	}

        //find the largest element.
	public static Location locateLargest(double[][] a){
                //create a new location object and initalize its attributes
		Location indices = new Location();
		indices.row = 0;
		indices.column = 0;
		indices.maxValue = a[0][0];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[i].length; j++)
				if (indices.maxValue < a[i][j]){
					indices.maxValue = a[i][j];
					indices.row = i;
					indices.column = j;
				}		
		return indices;
	}
}

//location class. 
class Location{
	public int row;
	public int column;
	public double maxValue;

}
