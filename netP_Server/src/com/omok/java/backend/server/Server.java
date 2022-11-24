package com.omok.java.backend.server;


import com.omok.java.data.room.RoomData;
import com.omok.java.data.user.UserData;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread {

	protected ServerSocket serverSocket;
	protected ArrayList<UserData> clientList;
	protected ArrayList<RoomData> roomList;
	private Integer serverPort = 30000;

	public ArrayList<RoomData> getRoomList() {
		return roomList;
	}

	private Server() {
		super("Server Thread");
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.clientList = new ArrayList<UserData>();
	}

	// Singleton Pattern: Initialization On Demand Holder Idiom
	public static Server getInstance(){
		return LazyHolder.INSTANCE;
	}

	public ArrayList<UserData> getClientList() {
		return clientList;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	protected ServerSocket getServerSocket() {
		return serverSocket;
	}

	@Override
	public void run(){

		ClientAcceptingServer.getInstance().setServer(this).start();
		RoomManagingServer.getInstance().setServer(this).start();

		while(true){


//			for (UI ui : clientList)  System.out.println(ui.toString());

		}

	}


	private static class LazyHolder {
		private static final Server INSTANCE = new Server();
	}
}
