package com.omok.Java.Backend.Manager;

import com.omok.Java.Data.Data;
import com.omok.Java.Data.UserData;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ServerStreamManager implements StreamManager {

	private HashMap<Integer, UserData> userMap;


	private ObjectInputStream fromClient;
	private ObjectOutputStream toClient;

	public ServerStreamManager(
			Socket serverSocket,
			ObjectInputStream fromClient,
			ObjectOutputStream toClient)
	{
		userMap = new HashMap<>();
		try {
			this.fromClient = fromClient;
			this.toClient = toClient;
			toClient.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(UserData user){
		try {
			userMap.put(user.userID, user);
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