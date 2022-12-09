package com.omok.Java.Backend.Server;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.ServerMain;
import com.omok.Java.UI.Frame.ServerFrame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public abstract class Server extends Thread implements DataHandler {

	private final String host = ServerMain.host;
	private final Integer portNum = ServerMain.portNum;
	private final ThreadGroup serverThreadGroup = ServerMain.serverThreadGroup;
	private final ThreadGroup clientThreadGroup = ServerMain.clientThreadGroup;
	private  ServerSocket serverSocket = ServerMain.serverSocket;
	private  HashMap<String, Socket> userNicknameSocketHashMap = ServerMain.userNicknameSocketHashMap;
	private  HashMap<Socket, ObjectInputStream> userSocketOISHashMap = ServerMain.userSocketOISHashMap;
	private  HashMap<Socket, ObjectOutputStream> userSocketOOSHashMap = ServerMain.userSocketOOSHashMap;



	public Server(ServerFrame serverFrame) {

	}

	@Override
	public void run() {
		System.out.println(this.toString() + "\tSTART");

		System.out.println(this.toString() + "\tRUNNING");
		new Thread( servers, new ClientAcceptingServer(servers, this) ).start();


		while(servers.activeCount() > 0);
		System.out.println(this.toString() + "\tEND");
	}


}
