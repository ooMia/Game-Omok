package backend;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import data.Data;

public class NetworkService implements Runnable {
	
	private final Socket socket;
	private final StreamManager streamManager;
	//private UserData userData;
	
	public NetworkService(Socket socket) {
		this.socket = socket;
		this.streamManager = new ClientStreamManager(socket);
	}
	
	@Override
	public void run() {
		
	}
	
	private class ClientStreamManager implements StreamManager {
		private ObjectInputStream fromServer;
		private ObjectOutputStream toServer;
		
		public ClientStreamManager(Socket socket) {
			try {
				this.fromServer = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
				this.toServer = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public Data receive() throws IOException, ClassNotFoundException {
			return (Data) fromServer.readObject();
		}
		@Override
		public void send(Data o) throws IOException {
			toServer.writeObject(o);
		}
	}
}
