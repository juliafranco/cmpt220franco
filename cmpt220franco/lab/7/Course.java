public class Course {
	//(The Course class) Revise the Course class as follows:
		
		//The array size is fixed in Listing 10.6. Improve it to automatically increase 
			//the array size by creating a new larger array and copying the contents of the current array to it.
		//Add a new method named clear() that removes all students from the course.
		
	private String courseName;
	private String[] students = new String[100]; //create students
	private int numberOfStudents;
	public Course(String courseName) { //add a course
		this.courseName = courseName;
		}

	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents++;
		if (numberOfStudents >= students.length) {
			String[] temp = new String[students.length * 2];
			System.arraycopy(students, 0, temp, 0, students.length);
			students = temp;
			}
		}
	
	public String[] getStudents() {
		return students;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void dropStudent(String student) {
	    for (int i=0 ;i < numberOfStudents; i++)
	    	if (students[i].equals(student)){
	    		for (int j = i; j < numberOfStudents -1; j++)
	    			students[j] = students[j + 1 ];
	    		numberOfStudents --;
	    		break;
	    	}
	}
	
	public void clear(){ //takes all of the students out of the class. 
		this.numberOfStudents = 0;
		for (int k = 0; k <students.length; k++)
			students[k] = "";
	}
}
