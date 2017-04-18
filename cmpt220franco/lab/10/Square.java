package ten;

import eight.SimpleGeometricObject;

public class Square extends SimpleGeometricObject implements Colorable{
	private double side;

	/**no args constructor for square*/
	public Square() {}

	/**constructor for square with side*/
	public Square(double side) {
		this.side = side;
		}
	
	/**constructor for a square with all attributes*/
	public Square(double side, String color, boolean filled) {
		super(color, filled);
		setSide(side);
		}

	/**setter method for side*/
	public void setSide(double side) {
		this.side = side;
		}

	/**getter method for side*/
	public double getSide() {
		return side;
		}

	@Override
	/**overrides getArea method in super class*/
	public double getArea() {
		return side * side;
		}

	@Override
	/**overrides getPerimeter method in super class*/
	public double getPerimeter() {
		return side * 4;
		}

	@Override
	/**implements howToColor method from interface*/
	public String howToColor() {
		return "Color all four sides";
		}

	@Override
	/**overrides the toString function in super class*/
	public String toString() {
		return super.toString() + "\nSide: " + side + "\nArea: " + getArea()
			+ "\nPerimeter: " + getPerimeter();
		}
}
