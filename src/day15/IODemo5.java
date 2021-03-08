package day15;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class IODemo5 {
	public static void main(String[] args) throws Exception {
		ByteArrayInputStream bis = new ByteArrayInputStream("HelloWorld".getBytes());
		StringBufferInputStream sbis = new StringBufferInputStream("Hello, hi, hey");
		SequenceInputStream sis = new SequenceInputStream(bis, sbis);
		int ch = 0;
		while((ch = sis.read()) != -1) {
			System.out.print((char) ch);
		}
	}
}
