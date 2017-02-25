import java.util.Scanner;

public class LinearEquation9_11 {
	public static void main (String[] args){
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.println ("Enter values for a-f ");
		double A = input.nextDouble();
		double B = input.nextDouble(); 
		double C = input.nextDouble();
		double D = input.nextDouble(); 
		double E = input.nextDouble(); 
		double F = input.nextDouble(); 
		
		LinearEquation equation1 = new LinearEquation ( A, B, C, D, E, F);
		
		//display result (getX & getY) 
		if (equation1.isSolvable()== false)
			System.out.print("The equation has no solution");
		else 
			System.out.println("The value of x is " + equation1.getX() + " and the value of y is "
					+ equation1.getY() );
	}

}
 class LinearEquation{
	 private double a;
	 private double b;
	 private double c;
	 private double d;
	 private double e;
	 private double f;
	 
	 LinearEquation( double newA, double newB, double newC, double newD, double newE, double newF){
		 a = newA;
		 b = newB;
		 c = newC;
		 d = newD;
		 e = newE;
		 f = newF;
	 }
	 
	 public double getA(){
		 return a;
	 }
	 
	 public double getB(){
		 return b;
	 }
	 
	 public double getC(){
		 return c;
	 }
	 
	 public double getD(){
		 return d;
	 }
	 
	 public double getE(){
		 return e;
	 }
	 
	 public double getF(){
		 return f;
	 }
	 
	boolean isSolvable(){
		if (((a * d) - (b * c)) != 0)
			return true;
		return false;
	}
	
	double getX(){
		double x = ((e * d) - (b * f) )/((a * d) - (b * c));
		return x;
	}
	
	double getY(){
		double y = ((a * f) - (e * c))/((a * d) - (b * c));
		return y;
	}
	
 }

