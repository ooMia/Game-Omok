package com.omok.Java.Backend.Server;


import com.omok.Java.Backend.Service.RoutineHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.ServerMain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// Server $ ClientAcceptingServer
public class ClientAcceptingServer extends Server {

	public static final Integer portNum = 30000;
	public static final String host = "127.0.0.1";
	public static final ThreadGroup serverThreadGroup = new ThreadGroup("Server");
	public static final ThreadGroup clientThreadGroup = new ThreadGroup("Client");

	public static ServerSocket serverSocket;
	public static HashMap<String, Socket> userNicknameSocketHashMap;
	public static HashMap<Socket, ObjectInputStream> userSocketOISHashMap;
	public static HashMap<Socket, ObjectOutputStream> userSocketOOSHashMap;



	ServerSocket serverSocket;

	public ClientAcceptingServer(
			ThreadGroup serverThreadGroup,
			Server server
	) {
		super();
		this.serverThreadGroup = serverThreadGroup;
		this.server = server;
		this.serverSocket = server.serverSocket;
		this.oisMap = server.oisMap;
		this.oosMap = server.oosMap;
	}

	@Override
	public void run() {
		System.out.println(this.getClass().toString() + "\tSTART");
		while (clientThreadGroup.activeCount() >= 0)
		{
			System.out.println(this.getClass() + "\tWAITING FOR CLIENTS...");
			try {
				Socket client = serverSocket.accept(); // made Thread blocked.
				System.out.print(this.getClass() + "\tUSER ACCEPTED... ");

				// √ ±‚»≠
				oosMap.put(client, new ObjectOutputStream(client.getOutputStream()));
				oosMap.get(client).flush();
				oisMap.put(client, new ObjectInputStream(client.getInputStream()));

			}
			catch (Exception e) {e.printStackTrace();}
		}
		System.out.println(this.getClass() + "\tEND");
	}

	@Override
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data) {

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
		public void routine_Login(Data login) throws IOException, ClassNotFoundException {
			String userID = null;
			String log = "Hello, World!".toUpperCase();
			try {
				userID = (String) fromClient.readObject();
				toClient.writeObject(log);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("userID: " + userID);
		}
	}

}
