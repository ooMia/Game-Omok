package com.omok.Java;

import com.omok.Java.Backend.Server.ClientAcceptingServer;
import com.omok.Java.Data.CodeType;
import com.omok.Java.UI.Frame.ServerFrame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerMain {
	public static final String host = "127.0.0.1";
	public static final Integer portNum = 30000;
	public static final ThreadGroup serverThreadGroup = new ThreadGroup("Server");
	public static final ThreadGroup clientThreadGroup = new ThreadGroup("Client");

	public static ServerSocket serverSocket;
	public static HashMap<String, Socket> userNicknameSocketHashMap;
	public static HashMap<Socket, ObjectInputStream> userSocketOISHashMap;
	public static HashMap<Socket, ObjectOutputStream> userSocketOOSHashMap;
	public static HashMap<Socket, Thread> userSocketThreadMap;
	public static ServerFrame serverFrame;

	public static void main(String[] args) throws IOException
	{
		serverSocket = new ServerSocket(portNum);
		userNicknameSocketHashMap = new HashMap<>();
		userSocketOISHashMap = new HashMap<>();
		userSocketOOSHashMap = new HashMap<>();
		userSocketThreadMap = new HashMap<>();

		serverFrame = new ServerFrame("HostConfigurePanel");
		serverFrame.setInnerPanel(CodeType.ON_START);
	}

	public static void run() {
		// run server threads
		new Thread(serverThreadGroup, new ClientAcceptingServer(serverFrame)).start();
	}
}
