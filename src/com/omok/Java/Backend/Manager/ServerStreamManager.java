package com.omok.Java.Backend.Manager;

import com.omok.Java.Data.Data;
import com.omok.Java.Data.User.UserData;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ServerStreamManager implements StreamManager {

	private HashMap<Socket, UserData> userMap;
	private ObjectInputStream fromClient;
	private ObjectOutputStream toClient;

	public ServerStreamManager(
			Socket serverSocket,
			HashMap<Socket, UserData> userMap,
			ObjectInputStream fromClient,
			ObjectOutputStream toClient)
	{
		this.userMap = userMap;
		this.fromClient = fromClient;
		this.toClient = toClient;
	}

	public void addUser(UserData user){
		try {
			userMap.put(user.userSocket, user);
		} catch (Exception e) { e.printStackTrace(); }
	}

	@Override
	public Data receive() throws IOException, ClassNotFoundException {
		return (Data) fromClient.readObject();
	}
	@Override
	public void send(Data data) throws IOException {
		toClient.writeObject(data);
	}

	@Override
	public ObjectInputStream getOIS() {
		return fromClient;
	}

	@Override
	public ObjectOutputStream getOOS() {
		return toClient;
	}

}