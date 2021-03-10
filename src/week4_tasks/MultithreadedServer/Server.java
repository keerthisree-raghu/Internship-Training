package week4_tasks.MultithreadedServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
	public static void main(String[] args) {
		ArrayList<Server> threads = new ArrayList<>();
		try(ServerSocket serverSocket = new ServerSocket(5000)) {
			while(true) {
				Socket socket = serverSocket.accept();
				Server server = new Server(socket, threads);
				threads.add(server);
				server.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Socket socket;
	private ArrayList<Server> threads;
	private PrintWriter output;
	
	public Server(Socket socket, ArrayList<Server> threads) {
		this.socket = socket;
		this.threads = threads;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			while(true) {
				String message = input.readLine();
				if(message.equals("logout")) {
					break;
				}
				printToAllClients(message);
				System.out.println("Server message: " + message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printToAllClients(String message) {
		for(Server thread : threads) {
			thread.output.println(message);
		}
	}
}
