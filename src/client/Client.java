package client;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		setup(); 
	}

	private static final String welcomeMsg = "Welcome to the client";
	private static final String connectionErrorMsg = "Couldn't connect to server. Please try again.";

	private static Socket socket;

	private static void start() {
		try {
			socket = new Socket(Setup.host, Setup.port);				
				
			var r = new Read(socket);
			var w = new Write(socket,r);
				
			new Thread(w).start();
			new Thread(r).start();
												
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
	public static void stop () throws IOException {
		socket.close();
	}
}
