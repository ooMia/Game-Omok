package com.omok.Java.UI;

import com.omok.Java.Backend.Manager.ClientStreamManager;
import com.omok.Java.Backend.Server.Server;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Backend.Manager.StreamManager;
import com.omok.Java.UI.Panel.Lobby.LobbyLeftPanel;
import com.omok.Java.UI.Panel.Lobby.LobbyRightPanel;
import com.omok.Java.UI.Panel.LobbyUI;
import com.omok.Java.UI.Panel.LoginUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

// create new window which contains a panel
// all objects which extends WindowFrame should override function run() from interface Runnable
public abstract class WindowFrame extends JFrame {

	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	// UI
	private Container container;
	private InnerPanel innerPanel;

	// Data
	protected Socket socket;

	StreamManager streamManager = null;


	public void setSocket(Socket socket) {
		if (streamManager == null) {
			try {
				System.out.println(this.getClass().toString() + ": setSocket");
				System.out.println(socket.getInputStream());
				System.out.println(socket.getOutputStream());

				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.flush();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

				streamManager= new ClientStreamManager(socket,ois,oos);
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.socket = socket;
		}
		else return;
	}
	public Socket getSocket() { return socket; }

	public WindowFrame(String title) {
		super(title);
		container = getContentPane();
	}

	public void setInnerPanel(InnerPanel innerPanel) {
		if (this.innerPanel != null) {
			this.innerPanel.setVisible(false);
			remove(this.innerPanel);
		}
		container.add(innerPanel);
		this.innerPanel = innerPanel;
		this.innerPanel.setVisible(true);
		repaint();

	}

	public void setInnerPanel(CodeType c) {

		switch (c){
			case LOGIN_STATUS -> changeInnerPanel_LoginToLobby();

		} // end of cases
	} // end of method:setInnerPanel


	private void changeInnerPanel_LoginToLobby(){

		int LobbyUI_columns[] = new int[10];
		Arrays.fill(LobbyUI_columns, 100);
		this.setInnerPanel(
				new LobbyUI(
						new LobbyLeftPanel(),
						new LobbyRightPanel(),
						new ImageIcon("./image/mainbackground.jpg").getImage(),
						LobbyUI_columns
				)
		);

		setTitle("LobbyUI");
		setPreferredSize(new Dimension(940, 780)); // setSize(new Dimension(940, 780));
		pack();
		repaint(); // setVisible(true);
		setLocationRelativeTo(null);
	}


	public ObjectInputStream getOIS() {
		return this.streamManager.getOIS();
	}
	public ObjectOutputStream getOOS() {
		return this.streamManager.getOOS();
	}

}
