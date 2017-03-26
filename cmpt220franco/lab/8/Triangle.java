public class Triangle extends SimpleGeometricObject {
	private double side1 = 1;
	private double side2 = 1;
	private double side3 = 1;
	
	public Triangle() {
	}
	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	public Triangle(double side1, double side2, double side3, String color, boolean filled) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		setColor(color);
		setFilled(filled);
	}
	/** Return side1 */
	public double getSide1() {
		return side1;
	}
	/** Set a new side1 */
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	/** Return side2 */
	public double getSide2() {
		return side2;
	}
	/** Set a new side2 */
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	/** Return side3 */
	public double getSide3() {
		return side3;
	}
	/** Set a new side2 */
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	/** Return area */
	public double getArea() {
		//using Heron's formula since only the three sides are known, not base and height.
		//s [semipermeter] = 1/2 ( a + b + c )
		//Area = sqrt ( s ( s-a) ( s-b) ( s-c) )
		double s = (this.side1 + this.side2 + this.side3)/2;
		return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s- this.side3));
	}
	/** Return perimeter */
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	/**prints a string description of the triangle*/
	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 +
				" side3 = " + side3;
	}
}
