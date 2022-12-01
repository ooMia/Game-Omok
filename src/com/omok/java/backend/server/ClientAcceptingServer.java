package com.omok.java.backend.server;

import com.omok.java.backend.server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Server $ ClientAcceptingServer
public class ClientAcceptingServer implements Runnable {

	Server server;
	ServerSocket serverSocket;
	ThreadGroup serverThreadGroup;

	public ClientAcceptingServer(ThreadGroup serverThreadGroup, Server server, ServerSocket serverSocket) {
		this.server = server;
		this.serverSocket = serverSocket;
		this.serverThreadGroup = serverThreadGroup;
	}

	@Override
	public void run() {
		System.out.println(this.toString() + "\tSTART");

		Socket client;
		final ThreadGroup clientThreadGroup = new ThreadGroup("Clients");

		try {
			System.out.println(this.toString() + "\tWAITING FOR CLIENTS...");
			client = serverSocket.accept(); // made Thread blocked.

			new Thread( clientThreadGroup, new MessageHandlerServer(clientThreadGroup, client) ).start();

			System.out.println(client.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

		while (clientThreadGroup.activeCount() >= 0);

		System.out.println(this.toString() + "\tEND");
	}







	// Server $ ClientAcceptingServer $ MessageHandlerServer
	class MessageHandlerServer implements Runnable {

		ThreadGroup clientThreadGroup;
		ObjectInputStream fromClient;
		ObjectOutputStream toClient;

		public MessageHandlerServer(ThreadGroup clientThreadGroup, Socket client) throws IOException {
			this.clientThreadGroup = clientThreadGroup;
			this.fromClient = new ObjectInputStream(  client.getInputStream() );
			this.toClient = new ObjectOutputStream( client.getOutputStream() );
		}

		@Override
		public void run() {
			System.out.println(this.toString() + "\tSTART");

			try {
				String msg = new String("Hello, World!").toUpperCase();
				toClient.writeObject(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}

			while (clientThreadGroup.activeCount() > 0);
			System.out.println(this.toString() + "\tEND");

		}
	}

}
