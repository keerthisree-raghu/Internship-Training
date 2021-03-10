package day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class InternationalizationIODemo {
	public static void main(String[] args) throws Exception {
		BufferedReader in;
		BufferedWriter out;
		
		// Resource bundle searches in the class path
		// File IO searches in the file path
		in = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.properties"), Charset.forName("UTF-8")));
		
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy.properties"), Charset.forName("UTF-8")));
		
		char c[] = new char[8];
		int i = 0;
		while((i = in.read(c)) != -1) {
			out.write(c, 0, i);
		}
		out.close();
		in.close();
	}
}
