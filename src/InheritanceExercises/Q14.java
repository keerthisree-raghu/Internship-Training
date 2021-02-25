package InheritanceExercises;

/*
 * Create a class Student consisting of name and rollno as members. Create a class exam inheriting student. 
 * It can have marks for 3 subjects.
 * Create a class result inheriting exam containing totalmark as member and a function to calculate the totalmark.
 */

public class Q14 {
	public static void main(String[] args) {
		Result res = new Result();
		String studentName = res.name = "John Doe";
		int rollNumber = res.rollNo = 111;
		res.subject1 = 88;
		res.subject2 = 73;
		res.subject3 = 91;
		System.out.println("Name: " + studentName);
		System.out.println("Roll Number: " + rollNumber);
		res.calculateResults();
	}
}

class Student {
	String name;
	int rollNo;	
}

class Exam extends Student {
	int subject1;
	int subject2;
	int subject3;
}

class Result extends Exam {
	public void calculateResults() {
		int totalMarks = subject1 + subject2 + subject3;
		System.out.println("Total Marks: " + totalMarks);
		int average = totalMarks / 3;
		System.out.println("Average: " + average);
		if(totalMarks > 45) {
			System.out.println("Result: Pass");
		}
		else {
			System.out.println("Result: Fail");
		}
	}
}
