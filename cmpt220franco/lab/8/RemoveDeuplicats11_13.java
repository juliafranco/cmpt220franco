import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDeuplicats11_13 {
	public static void main (String[] args){
		final int NUMBER_OF_ELEMENTS = 10;
		Scanner input = new Scanner(System.in); //creates scanner object
		ArrayList<Integer> numbers = new ArrayList<>();
		System.out.println("Enter " + NUMBER_OF_ELEMENTS + " Integers: ");
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++)
			numbers.add(input.nextInt()); //add the element to the list.
		System.out.print("The Items with duplicates removed are: ");
		RemoveDuplicate(numbers);
		 for (int k =0; k < numbers.size(); k++){
			  System.out.print(numbers.get(k) + " ");}
	}

	public static void RemoveDuplicate(ArrayList<Integer> List){
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            if (!temp.contains(List.get(i))) {
                temp.add(List.get(i));
            }
        }
        List.clear();
        List.addAll(temp);

/**this was the first attempt. It did not end well.*/
//		for (int i = 0, j = 0; i < List.size() -1 ; i++){//loops through all the elements
//			while (j < List.size()){
//				if (i < j){//checks to makes sure it's looking behind
//					if (List.get(i).equals(List.get(j))){
//						List.remove(j);
//						System.out.println("pop");} //removes the element at index j
//				}
//				j++;} //got through all the js before incrimenting i.
//		}
//		 //since the method is a Void and the output has to get out somehow....
//		 
	}//end of dups method
}//end of class
