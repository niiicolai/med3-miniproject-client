package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	static void main(String[] args){
		start(); 
	}

	static int port = 6666;
	static String host = "localhost";
	static Socket socket;

	static void start() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
