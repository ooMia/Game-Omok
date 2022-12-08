package com.omok.Java.UI.Panel;

import com.omok.Java.Backend.MessageHandler;
import com.omok.Java.Backend.Server.ClientAcceptingServer;
import com.omok.Java.Data.CodeType;
import com.omok.Java.UI.Panel.Structure.InnerPanel;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LoginUI extends InnerPanel {

	private JLabel label_nickname;
	private JTextField textField_nickname;
	private JButton button_login;

	private Image loginBackground;

	public LoginUI() {
		setLayout(null);

		// create objects
		textField_nickname = new JTextField();
		button_login = new JButton();
		button_login.setOpaque(false);
		button_login.setContentAreaFilled(false);
		button_login.setBorderPainted(false);

		loginBackground = new ImageIcon("./image/logint.png").getImage();

		// setBounds
		textField_nickname.setBounds(240, 328, 150, 30);
		button_login.setBounds(400, 328, 70, 30);

		// event
		textField_nickname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) tryLogin();
			}
		});
		button_login.addActionListener( e -> tryLogin() );

		// add
		add(textField_nickname);
		add(button_login);

	}

	public void tryLogin() {

		String id = textField_nickname.getText().trim();
		if(id.length() == 0) { return; }

		// socket 접속 시도
		try {
			String host = "127.0.0.1";
			final Integer portNum = 30002;

			Socket socket = new Socket(host, portNum);
			System.out.println(socket);
			super.setSocket(socket);
			System.out.println("setSocket: "+socket);

			System.out.println(super.getOIS().toString() + super.getOOS().toString());
//			MessageHandler mh = new ClientMessageHandler( socket, super.getOIS(), super.getOOS() );
//			mh.routine_Login(id);

		} catch (Exception e) {e.printStackTrace(); return;}

		super.updateInnerPanel(CodeType.LOGIN_STATUS);

}

	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		super.paintComponent(g2);
		if(loginBackground != null)
			g2.drawImage(loginBackground, 0, 0, null);
	}

private class ClientMessageHandler implements MessageHandler {

	ObjectInputStream fromServer;
	ObjectOutputStream toServer;

	public ClientMessageHandler(
			Socket socket,
			ObjectInputStream fromServer,
			ObjectOutputStream toServer
	) throws IOException {
		this.fromServer = fromServer;
		this.toServer = toServer;
	}

	@Override
	public void routine_Login(String id) throws IOException, ClassNotFoundException {
		String msg = (String) fromServer.readObject();
		System.out.println(msg); // HELLO WORLD
		toServer.writeObject(id); // SEND USERID
	}
}
}

