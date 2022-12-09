package com.omok.Java.Backend.Server;


import com.omok.Java.Backend.Service.RoutineHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// Server $ ClientAcceptingServer
public class ClientAcceptingServer implements Runnable {

	ThreadGroup serverThreadGroup;
	Server server;
	ServerSocket serverSocket;
	HashMap<Socket, ObjectInputStream> oisMap;
	HashMap<Socket, ObjectOutputStream> oosMap;

	public ClientAcceptingServer(
			ThreadGroup serverThreadGroup,
			Server server
	) {
		this.serverThreadGroup = serverThreadGroup;
		this.server = server;
		this.serverSocket = server.serverSocket;
		this.oisMap = server.oisMap;
		this.oosMap = server.oosMap;
	}

	@Override
	public void run() {
		System.out.println(this.getClass().toString() + "\tSTART");

		Socket client;
		final ThreadGroup clientThreadGroup = new ThreadGroup("Clients");

		while (clientThreadGroup.activeCount() >= 0)
		{
			System.out.println(this.getClass() + "\tWAITING FOR CLIENTS...");
			try {
				client = serverSocket.accept(); // made Thread blocked.
				System.out.print(this.getClass() + "\tUSER ACCEPTED... ");

				// 초기화
				oosMap.put(client, new ObjectOutputStream(client.getOutputStream()));
				oosMap.get(client).flush();
				oisMap.put(client, new ObjectInputStream(client.getInputStream()));

				// accept한 client를 userData 형태로 Server에 전달
				// 이후 Server는 userList에 추가
				RoutineHandler mh = new ServerRoutineHandler( client, getOIS(client), getOOS(client) );
				mh.routine_Login("");

			} catch (Exception e) {e.printStackTrace();}

		}

		System.out.println(this.getClass() + "\tEND");
	}

	private ObjectOutputStream getOOS(Socket socket) {
		return oosMap.get(socket);
	}
	private ObjectInputStream getOIS(Socket socket) {
		return oisMap.get(socket);
	}


	// Server $ ClientAcceptingServer $ RoutineHandler
	class ServerRoutineHandler implements RoutineHandler {

		ObjectInputStream fromClient;
		ObjectOutputStream toClient;

		public ServerRoutineHandler(
				Socket socket,
				ObjectInputStream OIS,
				ObjectOutputStream OOS
		) throws IOException {
			this.fromClient = OIS;
			this.toClient = OOS;
		}

		@Override
		public void routine_Login(String id) {
			String userID = null;
			String log = "Hello, World!".toUpperCase();
			try {
				toClient.writeObject(log);
				userID = (String) fromClient.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("userID: " + userID);
		}
	}

}
