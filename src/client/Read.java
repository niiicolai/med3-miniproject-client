package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Read implements Runnable {
	DataInputStream in;

	private static String serverPrefix = "[SERVER]: ";
		
	public Read(Socket socket) throws IOException {
		this.in = new DataInputStream(socket.getInputStream());
	}
		
	@Override
	public void run() {
		while (true) {
			var s = new Scanner(in);
			if (s.hasNextLine()) {
				var line = s.nextLine();
				System.out.println(serverPrefix + line.replaceAll("#n","\n"));
			}
		}
	}
}