import java.util.ArrayList;

public class Course {
	private String courseName;
	private ArrayList<String> students = new ArrayList<>(); //create students
	private int numberOfStudents;
	
	public Course(String courseName) { //add a course
		this.courseName = courseName;
		}

	public void addStudent(String student) {
		students.add(student);
		numberOfStudents++;
		}
	
	public ArrayList<String> getStudents() {
		return students;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void dropStudent(String student) {
	    if (students.contains(student)){
	    	students.remove(student);
	    }
	}
	
	public void clear(){ //takes all of the students out of the class. 
		students.clear();
	}
}
