package com.omok.java.frontend;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class UserLoginForm extends ClientView implements ActionListener {

	private final String serverIP = null;
	private final Integer serverPort = 30000;

	Socket socket;
	ObjectInputStream readStream;
	ObjectOutputStream writeStream;

	public UserLoginForm(WindowFrame frame) {
		super(frame);
	}


	@Override
	public void actionPerformed(ActionEvent actionEvent) {


	}


	public void test(){

		try {
			// 1. 클라이언트가 접속을 시도한다.
			socket = new Socket("127.0.0.1", 30000);

			// 2. 접속에 성공한 경우, 클라이언트 측은 입출력 스트림을 포함하여 유저 환경을 구축한다.
			writeStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			readStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

			writeStream.writeObject("Login");
			Object o = readStream.readObject();

			if (o.getClass() == String.class) System.out.println(o.toString());
else System.out.println("ERROR");

		} catch (Exception e) {
			e.printStackTrace();
		}



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
