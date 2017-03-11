public class MyString2 {
	//(Implement the String class) The String class is provided in the Java library.
	//Provide your own implementation for the following methods (name the new class MyString2 ):
	/**data field of String S*/
	String s = "";
	
	/**Constructor of a string*/
	public MyString2(String s){
		for (int i = 0; i < s.length(); i++)
			this.s += s.charAt(i) + "";
	}
	
	/**determines is a string is greater, less than, or equal to s.
	 * returns 1, -1, and zero respectively. */
	public int compare(String s) {
		int index = 0;
		if (this.s.length() < s.length())
			index = -1;
		if (s.length() < this.s.length())
			index = 1; 


		for (int i = 0; i < this.s.length(); i++) {
			if (this.s.charAt(i) < s.charAt(i))
				index = -(i + 1);
			if (this.s.charAt(i) > s.charAt(i))
				index = i + 1;
		}
		return index;
}
	
	/**returns a new MyString2 object with specific beginning that's a substring of the original*/
	public MyString2 substring(int begin){
		String b = "";
		for (int i = begin; i < s.length(); i++)
			b += s.charAt(i) + "";
		return new MyString2(b);
	}
	
	/**Converts string to upper case*/
	public MyString2 toUpperCase(){
		String n = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				n += String.valueOf((char)(s.charAt(i) - 32));
			else
				n += String.valueOf(s.charAt(i));
		}
		return new MyString2(n);
}

	/**Returns string as characters*/ 
	public char[] toChars(){
		char[] ch = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ch[i] = s.charAt(i);
		}
		return ch;
	}
		
	/** Return the boolean value as a MyString2 object */
	public static MyString2 valueOf(boolean b) {
		return (b ? new MyString2("true") : new MyString2("false"));
	}
	
	public static void main (String[] args){
		//create a new object
		MyString2 string6 = new MyString2("cakes");
		
		//test the compare method.
		System.out.print( string6.compare("rakes") + " | ");
		print(string6.substring(2)); 
		System.out.print(" | ");
		print(string6.toUpperCase());
		System.out.print(" | ");
		print(MyString2.valueOf(true));
		
	}
		
		/** Display a MyString2 object */
		public static void print(MyString2 str) {
			print(str.toChars());
		}

		/** Display an array of characters */
		public static void print(char[] chars) {
			for (int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
			}
			
	}
	
}


	
