package com.omok.java.backend.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread {

	final ThreadGroup servers = new ThreadGroup("Server");
	private ServerSocket serverSocket;

	public Server(Integer portNum) throws IOException {
		this.serverSocket = new ServerSocket(portNum);

	}

	@Override
	public void run() {
		System.out.println(this.toString() + "\tSTART");


		new Thread( servers, new ClientAcceptingServer(servers,this,  serverSocket) ).start();

		System.out.println(this.toString() + "\tRUNNING");
		while(servers.activeCount() > 0);

		System.out.println(this.toString() + "\tEND");
	}





}
