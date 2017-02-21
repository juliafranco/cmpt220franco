public class LargetestRowColumn8_10 {
	public static void main (String[] args){
		
		// randomly fill 1s and 0s into a 4 X 4 matrix
		int[][] matrix = new int[4][4];
		int count = 0;
		int currtotalrow = 0;
		int rowindex = 0;
		int currtotalcolumn = 0;
		int columnindex = 0;
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = (int)(Math.random() * 2);
				count++;
				//prints it.
				if (count % matrix[j].length == 0){
					System.out.printf("%-5s\n" , matrix[i][j]);
					} else {
						System.out.printf("%-5s" , matrix[i][j]);
					}
				}
		}
			//finds the column with the highest total
		for (int k = 0; k < matrix[0].length; k++){ //k is the column index
			int columntotal = sumColumn (matrix, k);
			if (columntotal > currtotalcolumn){
				currtotalcolumn = columntotal;
				columnindex = k;
				
			}
		}
		//finds the row with the highest total
		for (int l = 0; l < matrix[0].length; l++){ //l is the row index
			int rowtotal = sumRow (matrix, l);
			if (rowtotal > currtotalrow){
				currtotalrow = rowtotal;
				rowindex = l;				
			}
		}
			System.out.println("The row with the most 1s is row " + (rowindex + 1));
			System.out.println("The column with the most 1s is column " + (columnindex + 1));
	}
		//finds the first row and column with the most ones
		public static int sumColumn (int [][] m, int columnIndex){
			//find the total of each column.
				int totalcolumn = 0;
				for ( int row = 0; row < m.length ; row++){
					totalcolumn += m[row][columnIndex];
				}
				return totalcolumn;
		}
		public static int sumRow (int [][] m, int rowIndex){
			//find the total of each column.
				int totalrow = 0;
				for ( int column = 0; column < m.length ; column++){
					totalrow += m[rowIndex][column];
				}
				return totalrow;
		}

}
