package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Write implements Runnable {
		
	DataOutputStream out;
		
	public Write(Socket socket) throws IOException {
		this.out = new DataOutputStream(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		var reader = new InputStreamReader(System.in);
		var bufferedReader = new BufferedReader(reader);
		String clientMsg = "";
		while (true)
		{
			try {
				clientMsg = bufferedReader.readLine();
				out.writeUTF(clientMsg);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}