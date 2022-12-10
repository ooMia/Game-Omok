package com.omok.Java.UI.Frame;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Panel.LobbyUI;
import com.omok.Java.UI.Panel.LoginUI;
import com.omok.Java.UI.Panel.ServerLogUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientFrame extends WindowFrame implements DataHandler
{
	public Socket socket;
	public ObjectInputStream ois;
	public ObjectOutputStream oos;

	public ClientFrame(String title) {
		super(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public ClientFrame createChildClientFrame(String title, ClientFrame parentFrame){
		ClientFrame child = new ClientFrame(title);
		child.socket = parentFrame.socket;
		return child;
	}

	@Override
	public void setInnerPanel(CodeType codeType) {
		InnerPanel panel;
		switch (codeType){
			case ON_START -> {
				panel = new LoginUI(this);
				setPreferredSize(new Dimension(626, 418));
				setVisible(true);
			}
			case ON_LOGIN -> {
				panel = new LobbyUI(this);
			}
		}
	}

	@Override
	public void sendData(CodeType codeType, Data data) {
		switch (codeType) {
			case ON_LOGIN -> {
				this.socket = (Socket) data.obj;
				try {
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.flush();
					ois = new ObjectInputStream(socket.getInputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				InnerPanel innerPanel = new LobbyUI(this);
				setPreferredSize(new Dimension(338, 440));
				setVisible(true);
			}

		}
	}

	@Override
	public void onReceiveData(Data data) {

	}
}
