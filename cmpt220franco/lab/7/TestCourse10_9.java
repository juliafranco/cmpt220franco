public class TestCourse10_9 {
	public static void main (String[] args){
		//Write a test program that creates a course, adds three students, removes one, and displays 
		//the students in the course
		
		Course course1 = new Course("Data Structures");
		
		//add three students
		course1.addStudent("Peter Jones");
		course1.addStudent("Kim Smith");
		course1.addStudent("Anne Kennedy");
		
		//drop one
		course1.dropStudent("Kim Smith");
		
		//print the number and who's in it.
		System.out.println("Number of students in course1: "+ course1.getNumberOfStudents());
		String[] students = course1.getStudents();
		for (int i = 0; i < course1.getNumberOfStudents(); i++)
			System.out.print(students[i] + ", ");
		System.out.println();
	}

}
