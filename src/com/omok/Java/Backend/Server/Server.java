package com.omok.Java.Backend.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server extends Thread {

	public final ThreadGroup servers = new ThreadGroup("Server");

	protected ServerSocket serverSocket;
	protected HashMap<Socket, ObjectInputStream> oisMap;
	protected HashMap<Socket, ObjectOutputStream> oosMap;

	public Server(Integer portNum) throws IOException {
		this.serverSocket = new ServerSocket(portNum);
	}

	@Override
	public void run() {
		System.out.println(this.toString() + "\tSTART");

		System.out.println(this.toString() + "\tRUNNING");
		new Thread( servers, new ClientAcceptingServer(servers, this) ).start();


		System.out.println(this.toString() + "\tEND");
	}


}
