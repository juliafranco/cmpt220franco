package ten;

import eight.SimpleGeometricObject;

public class TestComapare13_5 {
	public static void main(String[] args) {
		// Create two Circle objects
		Circle circle1 = new Circle(6.5, "lavender", true);
		Circle circle2 = new Circle(14, "vermillion", false);

		// Display circle1
		System.out.println("\nCircle 1: ");
		System.out.println(circle1);

		// Display circle2
		System.out.println("\nCircle 2: ");
		System.out.println(circle2);

		// Display larger circle
		System.out.println("\nThe larger of the two circles was ");
		System.out.println(Circle.max(circle1, circle2));

		// Create two Rectangle objects
		Rectangle rectangle1 = new Rectangle(7, 3, "golden", false);
		Rectangle rectangle2 = new Rectangle(90, 2, "orange", true);

		// Display rectangle1
		System.out.println("\nRectangle 1: ");
		System.out.println(rectangle1);

		// Display rectangle2
		System.out.println("\nRectangle 2: ");
		System.out.println(rectangle2);

		// Display larger rectangle
		System.out.println("\nThe larger of the two rectangles was ");
		System.out.println(Rectangle.max(rectangle1, rectangle2));
		
		}
}
