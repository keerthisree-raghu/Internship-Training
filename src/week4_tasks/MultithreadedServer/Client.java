package week4_tasks.MultithreadedServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 5000)) {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			Scanner scan = new Scanner(System.in);
			String userInput, message, clientName = "null";
			Client client = new Client(socket);
			client.start();
			do {
				if (clientName.equals("null")) {
					System.out.print("Enter your name: ");
					userInput = scan.nextLine();
					clientName = userInput;
					output.println(userInput);
					if (userInput.equals("logout")) {
						break;
					}
				} else {
					message = "(" + clientName + "): ";
					System.out.println(message);
					userInput = scan.nextLine();
					output.println(userInput);
					if (userInput.equals("logout")) {
						break;
					}
				}
			} while (!userInput.equals("logout"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Socket socket;
	private BufferedReader input;

	public Client(Socket socket) throws Exception {
		this.socket = socket;
		this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		try {
			while (true) {
				String message = input.readLine();
				System.out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
