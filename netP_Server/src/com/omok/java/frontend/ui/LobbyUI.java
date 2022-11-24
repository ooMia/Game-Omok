package com.omok.java.frontend.ui;

import com.omok.java.backend.server.Server;
import com.omok.java.data.room.RoomData;
import com.omok.java.data.user.UserData;
import com.omok.java.frontend.WindowFrame;

import java.net.Socket;
import java.util.ArrayList;

public class LobbyUI extends UI {



	ArrayList<RoomData> rooms;

	public LobbyUI(WindowFrame frame, Server server, UserData clientUserData, Socket clientSocket) {
		super(frame, server, clientUserData, clientSocket);
		this.rooms = this.server.getRoomList();
	}
}
