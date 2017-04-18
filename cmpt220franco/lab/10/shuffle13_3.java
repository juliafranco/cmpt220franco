import java.util.ArrayList;
import java.util.Arrays;

public class shuffle13_3 {
	public static void main(String[] args) {
		// Create and arrayList
		ArrayList<Number> numbers = new ArrayList<>(Arrays.asList(14, 8, 9.07, 459, -5, 2, 3, 1, -0.98, 2));

		System.out.println("Before sorting, the list is: " + printList(numbers));		
		sort(numbers); //sorts the list.
		System.out.println("After the sorting, the list is: " + printList(numbers)); 	// Display list of sorted numbers
	}

	/** Sorts an ArrayList of numbers */
	public static void sort(ArrayList<Number> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			// Find the lowest in the list
			Number min = list.get(i);
			int minIndex = i;
			
			for (int j = i + 1; j < list.size(); j++) {
				if (min.doubleValue() > list.get(j).doubleValue()) {
					min = list.get(j);
					minIndex = j;}
			}

			// Swap list.get(i) with list.get(minIndex) if necessary
			if (minIndex != i) {
				list.set(minIndex, list.get(i));
				list.set(i, min);} 
			}
		}
	/**prints out the list of numbers without the enclosing brackets like the toString method.*/
	public static String printList(ArrayList<Number> list){
		String numbers = "";
		for (int i = 0; i < list.size(); i++){
			numbers += (list.get(i) + ", ");}
		return numbers;
	}
}


