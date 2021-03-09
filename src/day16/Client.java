package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket s;
	BufferedReader br, in;
	PrintWriter out;
	public Client() {
		try {
			while(true) {
				// Pass ip address and port number to the client socket
				s = new Socket("localhost", 2500);
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String serverMessage = br.readLine();
				System.out.println("Message from the server: " + serverMessage);
				out = new PrintWriter(s.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter a message to send to the client: ");
				String message = in.readLine();
				out.println(message);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client();
	}
}
