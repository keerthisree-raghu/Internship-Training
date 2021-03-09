package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss;
	Socket s;
	PrintWriter out;
	BufferedReader br, in;
	public Server() {
		try {
			// Port number - memory address where the request lands
			// > 1024 - non-reserved ports
			ss = new ServerSocket(2500);
			System.out.println("Server is ready.");
			while(true) {
				s = ss.accept();
				System.out.println(s);
				// true - appends data
				out = new PrintWriter(s.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter a message to send to the client: ");
				String message = in.readLine();
				out.println(message);
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String clientMessage = br.readLine();
				System.out.println("Message from client: " + clientMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}
