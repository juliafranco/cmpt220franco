public class MyInterger10_3 {
	public static void main (String[] args){
		//write program that tests all methods.
		MyInteger n1 = new MyInteger(9);
		System.out.println(n1.getValue() + " is even.: " + n1.isEven());
		System.out.println(n1.getValue() + " is prime.: " + n1.isPrime());
		System.out.println("322 is prime.: " + MyInteger.isPrime(322));

		char[] chars = {'1', '9', '2', '4'};
		System.out.println(MyInteger.parseInt(chars));

		String s = "49586";
		System.out.println(MyInteger.parseInt(s));

		MyInteger n2 = new MyInteger(74);
		System.out.println(n2.getValue() + " is odd.: " + n2.isOdd());
		System.out.println("65 is odd.: " + MyInteger.isOdd(65));
		System.out.println(n1.getValue() + " is equal to " + n2.getValue() + ".: " + n1.equals(n2));
		System.out.println(n1.getValue() + " is equal to 5.: " + n1.equals(5));
	}
}

class MyInteger {
	//An int data field named value that stores the int value represented by this object.
    private int value;

    //A constructor that creates a MyInteger object for the specified int value.
    public MyInteger(int newValue) {
        value = newValue;
    }
    
    //A getter method that returns the int value.
    public int getValue() {
        return value;
    }

  /**The methods isEven() , isOdd() , and isPrime() that return true if
   *  the value in this object is even, odd, or prime, respectively.*/
    public boolean isEven() {
        return (value % 2) == 0;
    }

    public boolean isOdd() {
        return (value % 2) == 1;
    }

    public boolean isPrime() {
    	 if (value == 1 || value == 2) 
             return true;
         else
             for (int i = 2; i < value; i++)
                 if (value % i == 0) return false;
         return true;
    }

    /**The static methods isEven(int) , isOdd(int) , and isPrime(int) that return true 
  		if the specified value is even, odd, or prime, respectively.*/
    public static boolean isEven(int myInt) {
        return (myInt % 2) == 0;
    }

    public static boolean isOdd(int myInt) {
        return (myInt % 2) == 1;
    }

    public static boolean isPrime(int myInt) {
        if (myInt == 1 || myInt == 2)
            return true;
        else 
            for (int i = 2; i < myInt; i++) 
                if (myInt % i == 0) return false;
            return true;
    }    

    /**The static methods isEven(MyInteger) , isOdd(MyInteger) , and isPrime(MyInteger) 
  		that return true if the specified value is even, odd, or prime, respectively.*/
    public static boolean isEven(MyInteger myInt) {
        return myInt.isEven();
    }

    public static boolean isOdd(MyInteger myInt) {
        return myInt.isOdd();
    }

    public static boolean isPrime(MyInteger myInt) {
        return myInt.isPrime();
    }

    /**The methods equals(int) and equals(MyInteger) that return true if the value in 
  		//this object is equal to the specified value.*/
    public boolean equals(int testInt) {
        if (testInt == value) 
            return true;
        return false;
    }

    public boolean equals(MyInteger myInt) {
        if (myInt.value == this.value) 
            return true;
        return false;
    }

    //A static method parseInt(char[]) that converts an array of numeric characters to an int value.
    public static int parseInt(char[] values) {
        int sum = 0;
        for (char i : values)
            sum += Character.getNumericValue(i);
        return sum;
    }

    //A static method parseInt(String) that converts a string into an int value.
    public static int parseInt(String value) {
        return Integer.parseInt(value);
    }
}
