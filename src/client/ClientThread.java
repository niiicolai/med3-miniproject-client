package client;

public abstract class ClientThread implements Runnable{
	private boolean stopped;
	
	public boolean isStopped () {
		return stopped;
	}
	public void stop() {
		stopped = true;
	}
}
