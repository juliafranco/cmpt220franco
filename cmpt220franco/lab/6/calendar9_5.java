import java.util.GregorianCalendar;

public class calendar9_5 {
	public static void main (String[] args){
		java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
//		
		System.out.println("The current date is " + (calendar.get(calendar.MONTH) + 1) + "/" + calendar.get(calendar.DAY_OF_MONTH)
		+ "/" + calendar.get(calendar.YEAR));

		calendar.setTimeInMillis (1234567898765L);
		//System.out.println(calendar.toString()); 
		System.out.println("The value of 1234567898765 milliseconds is " + (calendar.get(calendar.MONTH) + 1) + "/"
		+ calendar.get(calendar.DAY_OF_MONTH) + "/" + calendar.get(calendar.YEAR));
	}
}
