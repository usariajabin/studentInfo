
import java.util.ArrayList;
import java.util.Random;

public class Student {

	private String FirstName;
	private String LastName;
	private String ID = null;
	private String Credits = "";
	private String GPA = "";

	Random rand = new Random();
	int num = rand.nextInt(999999) + 100000;
	String generatedID = Integer.toString(num);

	// list of courses taken
	ArrayList<String> courseList = new ArrayList<String>();

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCredits() {
		return Credits;
	}

	public void setCredits(String credits) {
		Credits = credits;
	}

	public String getGPA() {
		return GPA;
	}

	public void setGPA(String gpa) {
		GPA = gpa;
	}

	public void setId(String id) {
		ID = id;
	}

	public String getId() {
		return ID;
	}

	public void setGeneratedId(String id) {
		generatedID = id;
	}

	public String getgeneratedId() {
		return generatedID;
	}

	public boolean ComparelastName(ArrayList<Student> a, String str) {
		for (int i = 0; i < a.size(); i++) {
			if (((a.get(i)).getLastName()).compareTo(str) == 0)
				return true;
		}

		return false;
	}

	public boolean equalsID(ArrayList<Student> a, String str) {
		for (int i = 0; i < a.size(); i++) {
			if (((a.get(i)).getId()).compareTo(str) == 0 || (a.get(i)).getgeneratedId().compareTo(str) == 0)
				return true;
		}
		return false;
	}

	public String ToString() {
		return LastName + "," + FirstName + "," + ID + "," + Credits + "," + GPA;
	}
}
