
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {

		ArrayList<Student> roster = new ArrayList<Student>();

		File file = new File("data.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line = br.readLine();

			// Student s = new Student();
			StringTokenizer tokenizer;

			while (line != null) {
				Student s = new Student();
				tokenizer = new StringTokenizer(line, ",");

				String token = tokenizer.nextToken();
				s.setLastName(token);

				token = tokenizer.nextToken();
				s.setFirstName(token);

				token = tokenizer.nextToken();
				s.setId(token);

				line = br.readLine();   //br reads the next line
				tokenizer = new StringTokenizer(line, ",");   
				token = tokenizer.nextToken();

				double currentCredits = 0;
				double tempCredit = 0;
				double currentGpa = 0;

				while (token.compareTo("-999") != 0) {

					s.courseList.add(token);  //add course credit if new student

					token = tokenizer.nextToken();
					tempCredit = Double.parseDouble(token);
					currentCredits += Double.parseDouble(token);

					token = tokenizer.nextToken();
					currentGpa += tempCredit * gradeCount(token); 

					line = br.readLine();
					tokenizer = new StringTokenizer(line, ",");
					token = tokenizer.nextToken();

					tempCredit = 0;
				}
				currentGpa = Math.round((currentGpa / currentCredits) * 100.0) / 100.0; // converting
																						// it
																						// to
																						// 2
																						// decimal
																						// place

				s.setCredits(Double.toString(currentCredits));
				s.setGPA(Double.toString(currentGpa));
				roster.add(s);
				line = br.readLine();
				line = br.readLine();

			} // done with reading from text file

			// adding students name manually

			Scanner input = new Scanner(System.in);

			System.out.println("Do you wanna add more students?");
			System.out.print("If yes press 1, if no press 2 :");
			int answer = input.nextInt();

			while (answer != 2) {
				Student s1 = new Student();
				Scanner input2 = new Scanner(System.in);

				System.out.print("What is the last name  :");
				String str = input2.next();
				s1.setLastName(str);

				System.out.print("What is the first name :");
				str = input2.next();
				s1.setFirstName(str);

				roster.add(s1);
				System.out.println("Do you wanna add more students?");
				System.out.print("If yes press 1 if no press 2 :");
				answer = input.nextInt();
			}
			System.out.println();

			for (int i = 0; i < roster.size(); i++) {

				System.out.print("Student's name & id : ");
				System.out.print(roster.get(i).getLastName() + ", " + roster.get(i).getFirstName());
				if (roster.get(i).getId() != null) {
					System.out.println(", " + roster.get(i).getId());
					System.out.println("Total credits       : " + roster.get(i).getCredits());
					System.out.println("Gpa (calculated)    : " + roster.get(i).getGPA());
				} else
					System.out.println(", " + roster.get(i).getgeneratedId());

				System.out.println("\n");

			}

		}

		catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	} // end of main

	public static double gradeCount(String x) {
		double grade = 0.0;
		if (x.compareTo("A") == 0 || x.compareTo("A+") == 0) {
			grade = 4;
			return grade;
		}

		else if (x.compareTo("A-") == 0) {
			grade = 3.7;
			return grade;
		} else if (x.compareTo("B+") == 0) {
			grade = 3.3;
			return grade;
		} else if (x.compareTo("B") == 0) {
			grade = 3.0;
			return grade;
		} else if (x.compareTo("B-") == 0) {
			grade = 2.7;
			return grade;
		} else if (x.compareTo("C+") == 0) {
			grade = 2.3;
			return grade;
		} else if (x.compareTo("C") == 0) {
			grade = 2.0;
			return grade;
		} else if (x.compareTo("C-") == 0) {
			grade = 1.7;
			return grade;
		} else
			return grade;
	}

}
