package day17;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationDemo {
	public static void main(String[] args) {
		// Default locale in system
		Locale locale = Locale.getDefault();
		System.out.println(locale); // en-IN -> English Indian
		
		// Set the default locale
		Locale.setDefault(new Locale("ta")); // ta -> Tamil
//		Locale.setDefault(new Locale("hi")); // hi -> Hindi
		locale = Locale.getDefault();
		System.out.println(locale);
		
		// From properties file
//		ResourceBundle rb = ResourceBundle.getBundle("day17/dictionary", locale); // base name of file must be the same
//		System.out.println(rb.getString("hello"));
		
		// From classes
		ResourceBundle rb = ResourceBundle.getBundle("day17.Dictionary", locale); // base name of java class must be same
		System.out.println(rb.getString("hello"));
	}
}
