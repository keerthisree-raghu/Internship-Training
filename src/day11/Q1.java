package day11;

import java.io.IOException;

public class Q1 {
	public static void main(String[] args) throws Exception {
		ExceptionTest exception = new ExceptionTest();
		exception.throwIOException(5);
//		try {
//			exception.throwIOException(5);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
	}
}

class ExceptionTest {
	public void throwIOException(int io) throws Exception {
		throw new IOException("IO Error");
	}
}

