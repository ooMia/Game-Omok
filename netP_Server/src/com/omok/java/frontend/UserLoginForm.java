package com.omok.java.frontend;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class UserLoginForm extends ClientView implements ActionListener {

	private String serverIP = null;
	private Integer serverPort = 30000;

	Socket socket;

	public UserLoginForm(WindowFrame frame) {
		super(frame);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}

//			try {
//
//
//		oos = new ObjectOutputStream(socket.getOutputStream());
//		oos.flush();
//		ois = new ObjectInputStream(socket.getInputStream());
//
//		ChatMsg obcm = new ChatMsg(UserName, "100", "Hello");
//		SendChatMsg(obcm);
//
//		ListenNetwork net = new ListenNetwork();
//		net.start();
//		TextSendAction action = new TextSendAction();
//		btnSend.addActionListener(action);
//		txtInput.addActionListener(action);
//		txtInput.requestFocus();
//		ImageSendAction action2 = new ImageSendAction();
//		imgBtn.addActionListener(action2);
//
//	} catch (NumberFormatException | IOException e) {
//		e.printStackTrace();
//		AppendText("connect error");
//	}


}
