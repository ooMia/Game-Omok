package com.omok.Java;

import com.omok.Java.Backend.Server.ClientAcceptingServer;
import com.omok.Java.UI.Frame.ServerFrame;
import com.omok.Java.UI.Panel.ServerLogUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import java.awt.*;
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

	public static void main(String[] args) throws IOException
	{
		serverSocket = new ServerSocket(portNum);
		userNicknameSocketHashMap = new HashMap<>();
		userSocketOISHashMap = new HashMap<>();
		userSocketOOSHashMap = new HashMap<>();

		// run server threads
		new Thread(new ClientAcceptingServer(serverThreadGroup, ))

		ServerFrame serverFrame = new ServerFrame("HostConfigurePanel");
		InnerPanel innerPanel = new ServerLogUI(serverFrame);
		serverFrame.setPreferredSize(new Dimension(338, 440));
		serverFrame.setInnerPanel(innerPanel);
		serverFrame.setVisible(true);
	}
}
