package com.omok.java.frontend.ui;

import com.omok.java.backend.server.Server;
import com.omok.java.data.user.UserData;
import com.omok.java.frontend.ClientView;
import com.omok.java.frontend.WindowFrame;

import java.net.Socket;

public abstract class UI extends ClientView {

	protected Server server;
	protected UserData clientUserData;
	protected Socket clientSocket;

	public UI(WindowFrame frame, Server server, UserData clientUserData, Socket clientSocket) {
		super(frame);
		this.server = server;
		this.clientUserData = clientUserData;
		this.clientSocket = clientSocket;
	}
}
