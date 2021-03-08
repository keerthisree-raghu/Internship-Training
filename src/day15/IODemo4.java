package day15;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class IODemo4 {
	public static void main(String[] args) throws Exception {
		String str = "hello world.";
		PushbackInputStream pbs = new PushbackInputStream(new ByteArrayInputStream(str.getBytes()));
		int ch = 0;
		while((ch = pbs.read()) != -1) {
			if((char) ch == 'h') {
				// The cursor will move back if 'h' is encountered and it will be converted to 'H'
				// The character will only be reread as 'H'. It will not be rewritten
				pbs.unread('H');
			}
			else {
				System.out.print((char) ch);
			}
		}
	}
}
