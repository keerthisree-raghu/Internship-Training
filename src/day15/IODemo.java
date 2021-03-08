package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class IODemo {
	public static void main(String[] args) {
		new CopyCommand().copy("abc.properties");
	}
}

class CopyCommand {
	public void copy(String filename) {
		// Byte stream classes
		FileInputStream fis = null;
		FileOutputStream fos = null;
		// Character stream classes
		FileReader reader = null;
//		FileWriter writer = null;
		// Try with resource
		try(FileWriter writer = new FileWriter("copyabc.properties")) {
//			fis = new FileInputStream(filename);
			// If the file doesn't exist it is created
//			fos = new FileOutputStream("copyabc.properties");
			// Number of bytes which can be read
//			System.out.println("Number of bytes: " + fis.available()); 
			// Reads characters one by one
//			System.out.println((char) fis.read()); // -1 indicates end of file
//			int letter;
//			byte b[] = new byte[fis.available()]; // Dynamic allocation
//			while((letter = fis.read(b)) != -1) {
//				// System.out.println((char) letter); // Loop runs 6 times
//				String s = new String(b); // Loop runs only once
//				System.out.println(s);
//			}
			// Optimized reading
//			int noOfBytesRead;
//			byte b[] = new byte[8];
			reader = new FileReader(filename);
//			writer = new FileWriter("copyabc.properties");
			int noOfCharRead;
			char c[] = new char[8];
			while((noOfCharRead = reader.read(c)) != -1) {
				// Reads only the remaining bytes after space has been filled
				String s = new String(c, 0, noOfCharRead); 
				System.out.println(s);
				writer.write(c, 0, noOfCharRead); // Write to file
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				// Only when the reader and writer are closed, the data will be committed
				reader.close();
//				writer.close(); // Try with resources will automatically close the connection
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
