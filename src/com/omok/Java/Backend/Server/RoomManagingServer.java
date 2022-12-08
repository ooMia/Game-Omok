package com.omok.Java.Backend.Server;

import java.io.Serializable;

public class RoomManagingServer extends Thread {

	private Server server;
	public Server getServer() {
		return server;
	}
	public RoomManagingServer setServer(Server server) {
		this.server = server;
		return this;
	}

	// Singleton Pattern: Initialization On Demand Holder Idiom
	public static RoomManagingServer getInstance() {
		return LazyHolder.INSTANCE;
	}
	private static class LazyHolder {
		private static final RoomManagingServer INSTANCE = new RoomManagingServer();
	}
	private RoomManagingServer() {
		super("RoomManagingServer Thread");
	}
//
//	void addRoom(RoomData room){
//		server.roomList.add(room);
//	}
//	void removeRoom(RoomData room){
//		server.roomList.remove(room);
//	}

	@Override
	public void run(){

		while(true){



//			// TEST
//			this.server.clientList.forEach(
//					ui -> System.out.printf(
//							"[%s] %s%n",
//							ui.getClass().toString(),
//							ui)
//			);

		}

	}


}
