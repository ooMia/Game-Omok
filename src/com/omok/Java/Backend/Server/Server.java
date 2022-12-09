package com.omok.Java.Backend.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server extends Thread {

	public static final String host = "127.0.0.1";
	public static final Integer portNum = 30002;

	public final ThreadGroup servers = new ThreadGroup("Server");

	protected ServerSocket serverSocket;
	protected HashMap<Socket, ObjectInputStream> oisMap;
	protected HashMap<Socket, ObjectOutputStream> oosMap;

	public Server(Integer portNum) throws IOException {
		this.serverSocket = new ServerSocket(portNum);
		this.oisMap = new HashMap<>();
		this.oosMap = new HashMap<>();
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
