package day5;

public class ProcessingArrays {
	// Processing an array can be done using both formats of for loops
	public static void main(String[] args) {
		// Processing one-dimensional array
		String str[] = {"hello", "world"};
		// New for loop format
		System.out.println("New format:");
		for(String s : str) {
			System.out.println(s);
		}
		// Old for loop format
		System.out.println("Old format:");
		int size = str.length;
		for(int i = 0; i < size; i++) {
			System.out.println(str[i]);
		}
		
		// Complex type object array
		ComplexArray complex[][] = new ComplexArray[2][3];
		// Row 1
		complex[0][0] = new ComplexArray("Row 1 Column 1");
		complex[0][1] = new ComplexArray("Row 1 Column 2");
		complex[0][2] = new ComplexArray("Row 1 Column 3");
		// Row 2
		complex[1][0] = new ComplexArray("Row 2 Column 1");
		complex[1][1] = new ComplexArray("Row 2 Column 2");
		complex[1][2] = new ComplexArray("Row 2 Column 3");
		
		// Processing two-dimensional array
		// New for loop format
		System.out.println("New format:");
		for(ComplexArray comp[] : complex) {
			for(ComplexArray c : comp) {
				System.out.print(c + "\t");
			}
			System.out.println("\n");
		}
		// Old for loop format
		System.out.println("Old format:");
		for(int i = 0; i < complex.length; i++) {
			for(int j = 0; j < complex[i].length; j++) {
				System.out.print(complex[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}
}

class ComplexArray {
	String stringValue;
	public ComplexArray(String stringValue) {
		this.stringValue = stringValue;
	}
	@Override
	public String toString() {
		return this.stringValue;
	}
}
