package day15;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;

public class IODemo3 {
	public static void main(String[] args) throws Exception {
		String str = "Jack &copy and Jill &copy; went up the hill...";
		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
		BufferedInputStream bfs = new BufferedInputStream(bis);
		CharArrayReader car = new CharArrayReader(str.toCharArray());
		BufferedReader br = new BufferedReader(car);
		System.out.println(bfs.markSupported());
		
		int ch = 0;
		boolean mark = false;
		while((ch = br.read()) != -1) {
			switch((char) ch) {
				case '&': {
					if(!mark) {
						// Remember mark for 32 bytes
						br.mark(32);
						mark = true;
					}
					break;
				}
				case ';': {
					if(mark) {
						// Copywrite symbol - 169
						System.out.print((char)169);
						mark = false;
					}
					break;
				}
				case ' ': {
					// Mark is there but no semicolon
					if(mark) {
						// Move the cursor to the last valid position
						br.reset();
						mark = false;
						System.out.print("&");
					}
					else {
						System.out.print(" ");
					}
					break;
				}
				default: {
					if(!mark) {
						System.out.print((char) ch);
					}
				}
			}
		}
	}
}
