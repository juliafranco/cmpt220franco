import java.util.Scanner;
import java.text.*;

public class Kgtog5_5 {
	
   static  DecimalFormat df = new DecimalFormat("###.#"); // To cut off after one decimal place
   //this came from the internet
	
	public static void main (String[] args){
		double POUNDS_TO_KG = 2.20; // a constant, the conversion factor
		//print kilograms/ to pounds (mult 2.2) increase 2 & pounds to kilos 
				//( divide 2.2) increase 5
		System.out.println("Pounds     Kilograms | Kilograms   Pounds");
		
	
		for ( int i = 1, j = 20; i < 200 &&  j < 520; i+= 2, j+= 5)  {
			System.out.println( df.format(i) + "                 " + df.format(i * POUNDS_TO_KG) + "   |  " + df.format(j) + "         " 
		+  df.format(j/ POUNDS_TO_KG));
			
		}
		
		//also the formating is a disaster. I'm not sure of an efficent way of fixing it.
		
	}
 
}
