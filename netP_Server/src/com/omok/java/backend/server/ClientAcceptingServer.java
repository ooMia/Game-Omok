package com.omok.java.backend.server;

import com.omok.java.data.room.LobbyData;
import com.omok.java.frontend.ui.LobbyUI;

import java.net.Socket;

public class ClientAcceptingServer extends Thread{

	private Server server;
	public Server getServer() {
		return server;
	}
	public ClientAcceptingServer setServer(Server server) {
		this.server = server;
		return this;
	}

	// Singleton Pattern: Initialization On Demand Holder Idiom
	public static ClientAcceptingServer getInstance(){
		return ClientAcceptingServer.LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		private static final ClientAcceptingServer INSTANCE = new ClientAcceptingServer();
	}
	private ClientAcceptingServer() {
		super("ClientAcceptingServer Thread");
	}



	@Override
	public void run(){

		while(true){

			try {
				Socket newClientSocket = this.server.serverSocket.accept();
				LobbyUI newClientUI = new LobbyData(newClientSocket);
				this.server.clientList.add(newClientUI);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// TEST
			this.server.clientList.forEach(
					ui -> System.out.println( String.format(
							"[%s] %s",
							ui.getName(),
							ui.getClass().toString())
					)
			);

		}

	}


}
