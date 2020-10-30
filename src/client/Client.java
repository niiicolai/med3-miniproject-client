package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		setup(); 
	}

	private static final String welcomeMsg = "Welcome to the client";
	private static final String connectionErrorMsg = "Couldn't connect to server. Please try again.";

	static int port = 6666;
	static String host = "localhost";
	static Socket socket;

	private static void start() {
		try {
			var socket = new Socket(host, port);				
				
			var w = new Write(socket);
			var r = new Read(socket);
				
			new Thread(w).start();
			new Thread(r).start();
								
			//socket.close();
			//dataInputStream.close();
			//dataOutputStream.close();
				
		} catch (UnknownHostException e) {
			reset();
		} catch (SocketException e) {
			reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void reset() {
		System.out.println(connectionErrorMsg);		
		setup();
	}
	
	public static void setup() {
		System.out.println(welcomeMsg);

		Setup.setupName();
		Setup.setupHost();
		Setup.setupPort();
			
		start();
	}
}
