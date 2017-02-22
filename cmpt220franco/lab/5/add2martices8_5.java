package five;

import java.util.Scanner;

public class add2martices8_5 {
	public static void main (String[] args){
		//prompt the user to enter 2 3 x 3 matrices
		final int ROWS = 3;
		final int COLUMNS = 3;
		final int MIDDLEROWINDEX = 1;
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		double[][] matrixA = new double[ROWS][COLUMNS];
		System.out.println("Enter the first " + matrixA.length + " by " + matrixA[0].length + " matrix");
		for (int i = 0; i < matrixA.length; i++)
			for (int j = 0; j < matrixA[i].length; j++)
				matrixA[i][j] = input.nextDouble();
		//should write a function to do this but.....
		double[][] matrixB = new double[ROWS][COLUMNS];
		System.out.println("Enter the second " + matrixB.length + " by " + matrixB[0].length + " matrix");
		for (int i = 0; i < matrixB.length; i++)
			for (int j = 0; j < matrixB[i].length; j++)
				matrixB[i][j] = input.nextDouble();
		
		double [][] matrixC = addMatrix (matrixA, matrixB);
		
		System.out.println(" The matrices added are as follows: ");
		for (int i = 0; i < matrixA.length && i < matrixB.length && i < matrixC.length; i++){//prints each row
			if (i == MIDDLEROWINDEX){
				for (int j = 0; j <matrixA[0].length; j++)
					if (j== (matrixA[0].length) -1){
						System.out.print(matrixA[i][j] + "    +    ");
					} else {
						System.out.print(matrixA[i][j] + " ");
					}
				for (int k = 0; k <matrixB[0].length; k++)
					if (k== (matrixB[0].length) -1){
						System.out.print(matrixB[i][k] + "    =    ");
					} else
						System.out.print(matrixB[i][k] + " ");
				for (int l = 0; l <matrixC[0].length; l++)
					if (l == (matrixC[0].length) - 1){
						System.out.print(matrixC[i][l] + " \n");
					} else {
						System.out.print(matrixC[i][l] + " ");
				}
			} else {
				for (int j = 0; j <matrixA[0].length; j++)
					if (j== (matrixA[0].length) -1){
						System.out.print(matrixA[i][j] + "         ");
					} else {
						System.out.print(matrixA[i][j] + " ");
					}
				for (int k = 0; k <matrixB[0].length; k++)
					if (k== (matrixB[0].length) -1){
						System.out.print(matrixB[i][k] + "         ");
					} else
						System.out.print(matrixB[i][k] + " ");
				for (int l = 0; l <matrixC[0].length; l++)
					if (l == (matrixC[0].length) - 1){
						System.out.print(matrixC[i][l] + " \n");
					} else {
						System.out.print(matrixC[i][l] + " ");
				}
			}
		}
	}

	public static double [][] addMatrix (double [][] a , double [][] b){
		final int ROWS = 3;
		final int COLUMNS = 3;
		//add the elements 
		double [][] c = new double [ROWS][COLUMNS];
		for (int i = 0; i < c.length; i++)
			for (int j = 0; j < c[i].length; j++)
			c[i][j] = a[i][j] + b[i][j];
		return c;
	}

}
