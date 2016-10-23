import java.util.ArrayList;

public class Course {

	private String CourseNumber;
	private double NumberOfCredits;
	private String GradeRecieved;

	public String getCourseNumber() {
		return CourseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		CourseNumber = courseNumber;
	}

	public double getNumberOfCredits() {
		return NumberOfCredits;
	}

	public void setNumberOfCredits(double numberOfCredits) {
		NumberOfCredits = numberOfCredits;
	}

	public String getGradeRecieved() {
		return GradeRecieved;
	}

	public void setGradeRecieved(String gradeRecieved) {
		GradeRecieved = gradeRecieved;
	}

	public boolean equalCourseId(ArrayList<String> a, String cId) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).compareTo(cId) == 0)
				return true;
		}
		return false;

	}

	public String toString() {
		return CourseNumber + ", " + NumberOfCredits + ", " + GradeRecieved;
	}
}
