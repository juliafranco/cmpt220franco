package nine;

public class Calc12_1Part2 {
	//this is the version without the try-catch block.
	public static void main(String[] args) {
		// Check number of strings passed
		if (args.length != 3) {
			System.out.println( "Usage: java Calculator operand1 operator operand2");
			System.exit(0);}
		
		if (!isNumeric(args[0])) {
			  System.out.println("Error. \"" + args[0] + "\" is not numeric.");
			  System.exit(0);
        }
        if (!isNumeric(args[2])) {
            System.out.println("Error. \"" + args[2] + "\" is not numeric.");
            System.exit(0);
        }
		// The result of the operation
		int result = 0;
		// Determine the operator
		switch (args[1].charAt(0)) {
		case '+': result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]); break;
		case '-': result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]); break;
		case '.': result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]); break;
		case '/': result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);}
		// Display result
		System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
	}
	//determines if the argument is a number or an invalid format.
	 public static boolean isNumeric(String s) {
	        for (char ch : s.toCharArray()) {
	            if (ch < '0' || ch > '9') return false;
	        }
	return true;
	}
}
