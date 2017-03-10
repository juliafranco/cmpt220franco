public class Circle2D {
	//Two double data fields named x and y that specify the center of the circle with getter methods.
	private double x;
	private double y;
	
	//A data field radius with a getter method.
	private double radius;
	
	//A no-arg constructor that creates a default circle with ( 0 , 0 ) for ( x , y ) and 1 for radius .
	public Circle2D(){
		x = 1;
		y = 1;
		radius = 1;
	}
	
	//A constructor that creates a circle with the specified x , y , and radius .
	public Circle2D( double newX, double newY, double newRadius){
		this.x = newX;
		this.y = newY;
		this.radius = newRadius;
		
	}
	
	//getter method for x
	public double getX(){
		return x;
	}
	
	//getter method for y
	public double getY(){
		return y;
	}
		
	//getter method for x
	public double getRadius(){
		return radius;
	}
	
	//A method getArea() that returns the area of the circle.
	double getArea(){
		double area = this.radius * this.radius * Math.PI;
		return area;
	}
	
	//A method getPerimeter() that returns the perimeter of the circle.
	double getPerimeter(){
		double perimeter = 2.0 * Math.PI * this.radius;
		return perimeter;
	}
	
	//A method contains(double x, double y) that returns true if the specified point ( x , y ) is inside this circle (see Figure 10.21a).
	public boolean contains(double x, double y){
		if (Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)) < this.radius) 
			return true;
		return false;
	}
	
	//A method contains(Circle2D circle) that returns true if the speciied circle is inside this circle (see Figure 10.21b).
	public boolean contains(Circle2D circle){
		if (Math.sqrt((this.x - circle.x) * (this.x - circle.x) + (this.y - circle.y) * (this.y - circle.y)) + circle.radius < this.radius)
			return true;
		return false;	
	}
	
	//A method overlaps(Circle2D circle) that returns true if the specified circle overlaps with this circle (see Figure 10.21c).
	public boolean overlaps(Circle2D circle) {
		if (Math.sqrt((this.x - circle.x) * (this.x - circle.x) + (this.y - circle.y) * (this.y - circle.y)) + circle.radius > this.radius
				&& Math.sqrt((this.x - circle.x) * (this.x - circle.x) + (this.y - circle.y) * (this.y - circle.y)) + circle.radius < this.radius 
				+ circle.radius)
			return true;
		return false;	
	}
}
