package com.omok.java.frontend.ui;

import com.omok.java.StreamManager;
import com.omok.java.backend.server.Server;
import com.omok.java.data.room.RoomData;
import com.omok.java.data.Data;
import com.omok.java.data.user.UserData;
import com.omok.java.frontend.WindowFrame;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class LobbyUI extends UI {



	ArrayList<RoomData> rooms;

	public LobbyUI(WindowFrame frame, Server server, UserData clientUserData, Socket clientSocket) {
		super(frame, server, clientUserData, clientSocket);
//		this.rooms = this.server.getRoomList();
	}





	private class ClientStreamManager implements StreamManager {

		private ObjectInputStream fromServer;
		private ObjectOutputStream toServer;

		public ClientStreamManager(Socket socket) {
			try {
				this.fromServer = new ObjectInputStream( new BufferedInputStream( socket.getInputStream() ));
				this.toServer = new ObjectOutputStream( new BufferedOutputStream( socket.getOutputStream() ));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public Data receive() throws IOException, ClassNotFoundException {
			return (Data) fromServer.readObject();
		}
		@Override
		public void send(Data data) throws IOException {
			toServer.writeObject(data);
		}

	}

}
