public class TestTwoDCircle10_11 {
	public static void main (String[] args){
		//creates a Circle2D object c1 ( new Circle2D(2, 2, 5.5) )
		Circle2D c1 =  new Circle2D(2, 2, 5.5); 
		
		//displays its area and perimeter
		System.out.println ("The area of the circle is " + c1.getArea() + " and the perimeter is " + c1.getPerimeter());
		
		//the result of c1.contains(3,3)
		if (c1.contains(3,3))
			System.out.print("The circle contains the point (3,3)" );
		else
			System.out.print("The circle does not contain the point (3,3)" );
		
		//the result of c1.contains(new Circle2D(4, 5, 10.5))
		if (c1.contains(new Circle2D(4, 5, 10.5)))
			System.out.println(", contain the circle with a center at (4, 5) and a radius of 10.5" );
		else
			System.out.println(", does not contain the circle with a center at (4, 5) and a radius of 10.5" );
		
		//result of c1.overlaps(new Circle2D(3, 5, 2.3))
		if (c1.overlaps(new Circle2D(3, 5, 2.3)))
			System.out.print(", and overlaps the circle with a center at (3, 5) and a radius of 2.3" );
		else
			System.out.print(", and does not overlap the circle with a center at (3, 5) and a radius of 2.3" );
	}
}
