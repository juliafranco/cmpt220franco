public class Rectangle9_1 {
	/*Main method**/
	public static void main (String[] args){
		//Create a rectangle with height 4 and width 40
		Rectangle rectangle1 = new Rectangle(4, 40);
		//print width, height, area and perimeter of each.
		System.out.println("A rectangle with dimensions " + rectangle1.width
		+ " and " + rectangle1.height + " has an area of " + rectangle1.getArea()
		+ " and a perimeter of " + rectangle1.getPerimeter());
		
		//Create a rectangle with height 3.5 and width 35.9
		Rectangle rectangle2 = new Rectangle(3.5 , 35.9);
		//print width, height, area and perimeter of each.
		System.out.println("A rectangle with dimensions " + rectangle2.width
		+ " and " + rectangle2.height + " has an area of " + rectangle2.getArea()
		+ " and a perimeter of " + rectangle2.getPerimeter());
		
		//two double fields width and height. Default value is 1. 
		//no arg constructor that creates a default rectangle
		//constructor that creates a rectangle with specified width and height.		
	}
}

//Define the circle class with two constructors
class Rectangle {
	double width;
	double height;
	
	/** Construct a rectangle with height and width of 1 */
	Rectangle() {
		width = 1;
		height = 1;
	}
	/** Construct a rectangle with a specified radius */
	Rectangle(double newWidth, double newHeight) {
		width= newWidth;
		height = newHeight;
	}
	
	double getArea(){
		return width * height;
	}
	double getPerimeter(){
		return (2 * width) + (2 * height);
	}

}
