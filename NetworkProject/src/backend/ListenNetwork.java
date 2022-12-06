package backend;

import java.net.Socket;

public class ListenNetwork extends Thread {
	protected Socket socket;
	
	private ListenNetwork() {
		
	}
	
	private static class LazyHolder {
		private static final ListenNetwork INSTANCE = new ListenNetwork();
	}
	
	public static ListenNetwork getInstance(){
		return LazyHolder.INSTANCE;
	}
	
	@Override
	public void run() {
		while(true) {
			
		}
	}
}
