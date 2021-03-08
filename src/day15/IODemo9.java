package day15;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class IODemo9 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.google.com/index.html");
		URLConnection urlConn = url.openConnection();
		urlConn.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		FileOutputStream fos = new FileOutputStream("google.html");
		
		int ch = 0;
		while((ch = br.read()) != -1) {
			System.out.print((char) ch);
			fos.write(ch);
		}
	}
}
