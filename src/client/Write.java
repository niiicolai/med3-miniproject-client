package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Write extends ClientThread {
		
	private DataOutputStream out;
	private String clientMsg = "";
	private Read read; 
	private String exitCommand = "EXIT";
	
	public Write(Socket socket,Read read) throws IOException {
		this.out = new DataOutputStream(socket.getOutputStream());
		this.read = read;
	}
	
	@Override
	public void run() {
		var reader = new InputStreamReader(System.in);
		var bufferedReader = new BufferedReader(reader);
		
		try {
			// Message the server the name as the first message
			message(Setup.name);

			while (!isStopped())
			{
				clientMsg = bufferedReader.readLine();
				message(clientMsg);
			}
			out.close ();
			read.stop ();
			Client.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void message(String msg) throws IOException {
		out.writeUTF(msg);
		out.flush();
		
		if (msg.toUpperCase().equals(exitCommand)) {
			stop();
		}
	}
}