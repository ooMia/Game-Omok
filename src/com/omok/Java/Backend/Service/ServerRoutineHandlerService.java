package com.omok.Java.Backend.Service;

import com.omok.Java.Data.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerRoutineHandlerService implements RoutineHandler {

	private Socket socket;
	private ObjectInputStream fromClient;
	private ObjectOutputStream toClient;

	public ServerRoutineHandlerService(Socket socket, ObjectInputStream fromClient, ObjectOutputStream toClient) {
		this.socket = socket;
		this.fromClient = fromClient;
		this.toClient = toClient;
	}

	@Override
	public void routine_Login(Data login) throws IOException, ClassNotFoundException {

	}
}
