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
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public ClientFrame createChildClientFrame(String title, ClientFrame parentFrame){
		ClientFrame child = new ClientFrame(title);
		child.socket = parentFrame.socket;
		return child;
	}

	@Override
	public void setInnerPanel(CodeType codeType) {

		switch (codeType){
			case ON_START -> {
				setPreferredSize(new Dimension(626, 418));
				setInnerPanel(new LoginUI(this));
			}
			case ON_LOGIN -> {
				setPreferredSize(new Dimension(940, 780));
				setInnerPanel(new LobbyUI(this));
			}
		}
		pack();
		setLocationRelativeTo(null);
	}


	@Override
	public void sendData(CodeType codeType, Data data) {


	}

	@Override
	public void onReceiveData(Data data, WindowFrame frame) {
		getInnerPanel().onReceiveData(data, this);
	}


}
