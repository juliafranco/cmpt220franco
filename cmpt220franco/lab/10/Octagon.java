package ten;

public class Octagon extends SimpleGeometricObjectWithoutComparable implements Comparable<Octagon>, Cloneable {
	private double side;
	
	/**no args constructor*/
	public Octagon(){}
	
	/**constructor for side*/
	public Octagon(double side){
		this.side = side;
	}
	
	/**constructor for all attributes*/
	public Octagon(double side, String color, boolean filled) {
		super(color, filled);
		this.side = side;
		}
	
	/**getter method for side*/
	public double getSide() {
		return side;
	}

	/**setter method for side*/
	public void setSide(double side) {
		this.side = side;
	}


	@Override 
	/** Return the area of Octagon */
	public double getArea() {
		return (2 + 4 / Math.sqrt(2)) * side * side;
	}

	@Override 
	/** Return the perimeter of Octagon */
	public double getPerimeter() {
		return 8 * side;
	}

	@Override 
	/** Implement compareTo method */
	public int compareTo(Octagon octagon) {
		if (getArea() > octagon.getArea())
			return 1;
		else if (getArea() < octagon.getArea())
			return -1;
		else
			return 0;
	}

	@Override 
	/** Override the clone method defined in the Object class*/
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	@Override 
	/** Return a String description of Octagon object*/
	public String toString() {
		return super.toString() + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
		}
}
