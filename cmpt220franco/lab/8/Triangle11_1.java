import java.util.Scanner;

public class Triangle11_1 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //creates scanner object
		System.out.println("Enter 3 sides of a triangle, a color, and a boolean value");
		//sets all the values from the user input. 
		Triangle triangle = new Triangle(input.nextDouble(), input.nextDouble(),
				input.nextDouble(), input.next(), input.nextBoolean());
		//prints out triangle parts. 
		System.out.println("A triangle " + triangle.toString());
		System.out.println("The color is " + triangle.getColor() + " and is filled?: " +
		triangle.isFilled());
		System.out.println("The area is " + triangle.getArea() + " and the perimeter is "
		+ triangle.getPerimeter());
	}
}
