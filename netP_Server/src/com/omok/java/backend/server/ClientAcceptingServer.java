package com.omok.java.backend.server;

import com.omok.java.backend.service.ClientService;

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
				ClientService newClientService = new ClientService(newClientSocket);
				this.server.clientList.add(newClientService);
				new Thread(newClientService).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// TEST
			this.server.clientList.forEach(
					clientService -> System.out.println( String.format(
							"[%s] %s",
							clientService.getClass().toString(),
							clientService)
					)
			);

		}

	}


}
