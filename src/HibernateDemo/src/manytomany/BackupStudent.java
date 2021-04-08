package manytomany;

import java.util.Set;

public class BackupStudent {
	public BackupStudent() {
		// TODO Auto-generated constructor stub
	}

	private int studentId;
	private String studentName;
	private int marks;
	private Set<Training> trainings;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
