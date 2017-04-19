package ten;

public class Octogon11_11 {
	public static void main (String[] args) throws CloneNotSupportedException{
		
		Octagon octoMom = new Octagon(5);
		
		System.out.println("The perimeter of the Octagon 'OctoMom' is " + octoMom.getPerimeter() + 
				" and the area is " + octoMom.getArea());
		
		// Create new object using the clone method
		System.out.println("Cloning Octagon...");
		Octagon octoDad = (Octagon)octoMom.clone();
		
		// Compare the two object using compareTo method
		int result = (octoMom.compareTo(octoDad));
		if (result == 1)
			System.out.println("OctoMom is greather than its clone, OctoDad.");
		else if (result == -1)
			System.out.println("OctoMom is less than its clone, OctoDad."); 
		else
			System.out.println("OctoMom is equal to its clone, OctoDad.");
		}
}
