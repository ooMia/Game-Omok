package com.omok.Java.UI.Frame;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
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
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data) {

	}
}
