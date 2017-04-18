package ten;

import eight.SimpleGeometricObject;

public class Rectangle extends SimpleGeometricObject {
	private double width;
	private double height;
	
	/**constructor for rectangle object*/
	public Rectangle() {}
	
	/**constructor for rectangle object with height and width*/
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		}
	
	/**constructor for rectangle object with all attributes*/
	public Rectangle(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
		}
	/** Return width */
	public double getWidth() {
		return width;
		}
	
	/** Set a new width */
	public void setWidth(double width) {
		this. width = width;
		}
	
	/** Return height */
	public double getHeight() {
		return height;
		}
	
	/** Set a new height */
	public void setHeight(double height) {
		this.height = height;
		}
	
	@Override 
	/** Return area */
	public double getArea() {
		return width * height;
		}
	
	@Override 
	/** Return perimeter */
	public double getPerimeter() {
		return 2 * (width * height);
		}
	
	@Override /** Return String discription of this rectangle */
	public String toString() {
		return super.toString() + "\nWidth: " + width + "\nHeight: " + height+ "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
		}
}

