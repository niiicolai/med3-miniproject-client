package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	static void main(String[] args){
		start (); 
	}
	static int port = 6666;
	static String host = "localhost";
	static Socket socket;

	static void start() {
		try {
			socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
