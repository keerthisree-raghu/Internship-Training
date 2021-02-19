package day1;
import java.util.Scanner;

// Question 13: Write a program to calculate the result of students, taking number of students as the rows and marks as the columns of a two dimensional array. 

public class StudentResults {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		// Get marks from user for each student
		System.out.print("Number of students: ");
		int numberOfStudents = scan.nextInt();
		System.out.print("Number of subjects: ");
		int numberOfSubjects = scan.nextInt();
		int marks[][] = new int[numberOfStudents][numberOfSubjects];
		for(int i = 0; i < numberOfStudents; i++) {
			System.out.println("Enter marks of student " + (i+ 1));
			for(int j = 0; j < numberOfSubjects; j++) {
				marks[i][j] = scan.nextInt();
			}
		}
		// Calculate the total and average for each student
		for(int i = 0; i < numberOfStudents; i++) {
			int total = 0;
			float average = 0.0f;
			for(int j = 0; j < numberOfSubjects; j++) {
				total += marks[i][j];
			}
			average = total / numberOfSubjects;
			System.out.println("Total Marks of Student " + (i + 1) + ": " + total);
			System.out.println("Average Score of Student " + (i + 1) + ": " + average);
			if(average >= 45.0) {
				System.out.println("Student " + (i + 1) + " has passed.");
			}
			else {
				System.out.println("Student " + (i + 1) + " has failed.");
			}
		}
	}
	
}
