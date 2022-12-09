package com.omok.Java.Backend.Service;

import com.omok.Java.Data.Data;
import com.omok.Java.Data.Room.RoomData;
import com.omok.Java.Data.User.UserData;
import com.omok.Java.UI.Panel.LoginUI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientRoutineHandlerService implements RoutineHandler {

	private Socket socket;
	private ObjectInputStream fromServer;
	private ObjectOutputStream toServer;

	public ClientRoutineHandlerService(Socket socket, ObjectInputStream fromServer, ObjectOutputStream toServer) {
		this.socket = socket;
		this.fromServer = fromServer;
		this.toServer = toServer;
	}

	@Override
	public void routine_Login(Data login) throws NullPointerException
	{
		UserData user = login instanceof UserData ? ((UserData) login) : null;
		if (user.userLocation.innerPanel instanceof LoginUI) {

		}
	}
}