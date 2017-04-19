package ten;

public class Comparable13_9 {
	public static void main(String[] args) {
		// Create three Circle objects
		Circle2 circle1 = new Circle2(6.7, "orange", true);
		Circle2 circle2 = new Circle2(8, "purple", true);
		Circle2 circle3 = new Circle2(6.7, "blue", false);

		// Display results
		System.out.println("Circle1 radius: " + circle1.getRadius());
		System.out.println("Circle2 radius: " + circle2.getRadius());
		System.out.println("Circle3 radius: " + circle3.getRadius());

		System.out.println("Circle1 is " + (circle1.equals(circle2) ? "" : "not ") +
			"equal to circle2");

		System.out.println("Circle1 is " + (circle1.equals(circle3) ? "" : "not ") +
			"equal to circle3");
		}
}
