package ten;

import eight.SimpleGeometricObject;

public class Colorable13_7 {
	public static void main(String[] args){
		// Create an array of five GeometricObjects
		SimpleGeometricObject[] squares = {new Square(6.7), new Square(.004), new Square(18), new Square(3), new Square(10)};
		
		// Display the area and invoke the howToColor method for each SimpleGeometricObject
		for (int i = 0; i < squares.length; i++) {
			System.out.println("\nSquare #" + (i + 1));
			System.out.println("Area: " + squares[i].getArea());
			System.out.println("How to color: " + ((Square)squares[i]).howToColor());
			} 
	}
}
