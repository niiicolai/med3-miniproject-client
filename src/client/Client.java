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
	
	static String exitCommand = "EXIT";

	static void start() {
		try {
			socket = new Socket(host, port);
			output = new DataOutputStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());
			reader = new InputStreamReader(System.in);
			bufferedReader= new BufferedReader(reader);
			boolean shouldRun= true;
			
			String clientMessage = "";
			String serverMessage = "";
			
			while(shouldRun=true)
			{
				clientMessage = BufferedReader.readLine();
				shouldRun = !clientMsg.toUpperCase().equals(exitCommand);
						
				dataOutputStream.writeUTF(clientMessage);
				flushOutpuStream.flush();
				
				dataInputStream.readUTF(serverMessage);
				
				System.out.println("[SERVER]: " +serverMessage);
				
			}
			
			
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
