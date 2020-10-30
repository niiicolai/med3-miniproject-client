package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Write implements Runnable {
		
	private DataOutputStream out;
	private String clientMsg = "";
		
	public Write(Socket socket) throws IOException {
		this.out = new DataOutputStream(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		var reader = new InputStreamReader(System.in);
		var bufferedReader = new BufferedReader(reader);
		
		try {
			// Message the server the name as the first message
			message(Setup.name);

			while (true)
			{
				clientMsg = bufferedReader.readLine();
				message(clientMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void message(String msg) throws IOException {
		out.writeUTF(msg);
		out.flush();
	}
}