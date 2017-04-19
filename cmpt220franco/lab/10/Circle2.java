package ten;

import ten.SimpleGeometricObjectWithoutComparable;

public class Circle2 extends SimpleGeometricObjectWithoutComparable implements Comparable<Circle2>{
	private double radius;

	/**constructor for circle*/
	public Circle2() {}
	
	/**constructor for circle with specified radius*/
	public Circle2(double radius) {
		this.radius = radius;
	}
	/**constructor for circle with specificed attributes*/
	public Circle2(double radius, 
		String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override 
	/** Return area */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter() {
		return 2 * radius;
	}

	@Override 
	/** Return perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	@Override 
	/** Return String discription of Circle object */
	public String toString() {
		return super.toString() + "\nRadius: " + radius + "\nArea: " + getArea() +
			"\nDiameter: " + getDiameter() + "\nPerimeter: " + getPerimeter();
	}
	
	@Override 
	/** Return true if objects radii are the same */
	public boolean equals(Object object) {
		return this.compareTo((Circle2)object) == 0;
		}
	
	
	// Implement the compareTo method defined in Comparable
	public int compareTo(Circle2 object) {
		if (this.getRadius() > (object).getRadius())
			return 1;
		else if (this.getRadius() < (object).getRadius())
			return -1;
		else
			return 0;
	}
}