package eight;

public abstract class SimpleGeometricObject implements Comparable<SimpleGeometricObject> {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	/** Construct a default geometric object */
	public SimpleGeometricObject() {
		dateCreated = new java.util.Date();
	}
	/** Construct a geometric object with the specified color
	* and filled value */
	public SimpleGeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	/** Return color */
	public String getColor() {
		return color;
	}
	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}
	/** Return filled. Since filled is boolean,
	its getter method is named isFilled */
	public boolean isFilled() {
		return filled;
	}
	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	/** Return a string representation of this object */
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
	/** Abstract method getMax */
	public static SimpleGeometricObject max(SimpleGeometricObject object1, SimpleGeometricObject object2) {
		return object1.compareTo(object2) == 1 ? object1 : object2;
		}
	@Override 
	// Implement the compareTo method defined in Comparable
	public int compareTo(SimpleGeometricObject object) {
		if (this.getArea() > object.getArea())
			return 1;
		else if (this.getArea() < object.getArea())
			return -1;
		else
			return 0;
}
	 /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
}
