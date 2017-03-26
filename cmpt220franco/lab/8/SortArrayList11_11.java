import java.util.ArrayList;
import java.util.Scanner;

public class SortArrayList11_11 {
	public static void main (String[] args){
		final int NUMBER_OF_ELEMENTS = 5;
		Scanner input = new Scanner(System.in); //creates scanner object
		ArrayList<Integer> numbers = new ArrayList<>();
		System.out.println("Enter " + NUMBER_OF_ELEMENTS + " Integers: ");
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++)
			numbers.add(input.nextInt()); //add the element to the list.
		System.out.print("The Items as sorted are: ");
		sort(numbers);
                 for (int k =0; k < numbers.size(); k++){
			  System.out.print(numbers.get(k) + ", ");}
	}

	/**sorts a given list of numbers*/
	public static void sort(ArrayList<Integer> List){
	//sorts the list into increasing order. 
		  for (int i = 0; i < List.size() - 1; i++){
			  for (int j = i + 1; j < List.size(); j++){
				  if (List.get(i) > List.get(j)) {
					  int temp = List.get(j);
		              List.set(j, List.get(i));
		              List.set(i, temp);}
		        }
		    }
	}//closes out sort method. 
}//closes out whole file
