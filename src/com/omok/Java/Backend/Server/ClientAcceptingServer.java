package com.omok.Java.Backend.Server;


import com.omok.Java.Backend.Service.ClientService;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.ServerMain;
import com.omok.Java.UI.Frame.ServerFrame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// Server $ ClientAcceptingServer
public class ClientAcceptingServer extends Server
{
	private ThreadGroup serverThreadGroup = new ThreadGroup("Server");
	private ThreadGroup clientThreadGroup = new ThreadGroup("Client");

	private ServerSocket serverSocket;
	private HashMap<String, Socket> idSocketMap;
	private HashMap<Socket, ObjectInputStream> oisMap;
	private HashMap<Socket, ObjectOutputStream> oosMap;
	private HashMap<Socket, Thread> threadMap;

	public ClientAcceptingServer(ServerFrame serverFrame) {
		super(serverFrame);
		this.serverSocket = ServerMain.serverSocket;
		this.idSocketMap = ServerMain.userNicknameSocketHashMap;
		this.oisMap = ServerMain.userSocketOISHashMap;
		this.oosMap = ServerMain.userSocketOOSHashMap;
		this.threadMap = ServerMain.userSocketThreadMap;
	}

	@Override
	public void run() {
		System.out.println(this.getClass().toString() + "\tSTART");
		while (serverThreadGroup.activeCount() > 1)
		{
			System.out.println(this.getClass() + "\tWAITING FOR CLIENTS...");
			try {
				Socket client = serverSocket.accept(); // made Thread blocked.
				System.out.print(this.getClass() + "\tUSER ACCEPTED... ");

				oosMap.put(client, new ObjectOutputStream(client.getOutputStream()));
				oosMap.get(client).flush();
				oisMap.put(client, new ObjectInputStream(client.getInputStream()));

				threadMap.put(client, new Thread(new ClientService()));
			}
			catch (Exception e) {e.printStackTrace();}
		}
		System.out.println(this.getClass() + "\tEND");
	}

	public void login(String userID) {

	}

	public void logout(String userID) {

	}

	@Override
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data) {

	}

}
