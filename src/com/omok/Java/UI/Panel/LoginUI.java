package com.omok.Java.UI.Panel;

import com.omok.Java.Backend.Service.RoutineHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.ServerMain;
import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Frame.ServerFrame;
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

import static com.omok.Java.Data.CodeType.ON_LOGIN;

public class LoginUI extends InnerPanel {

	public static ClientFrame frame;

	private JLabel label_nickname;
	private JTextField textField_nickname;
	private JButton button_login;

	private Image loginBackground;

	public LoginUI(ClientFrame clientFrame)
	{
		super(clientFrame);
		this.frame = clientFrame;
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

	public void tryLogin()
	{
		String userNickname = textField_nickname.getText().trim();
		if (userNickname.length() != 0) {
			try {
				Socket socket = new Socket(ServerMain.host, ServerMain.portNum);
				System.out.println("CONNECTED: " + socket);

				frame.oos = new ObjectOutputStream(socket.getOutputStream());
				frame.oos.flush();
				frame.ois = new ObjectInputStream(socket.getInputStream());
				frame.oos.writeObject(new Data(userNickname));

			} catch (IOException e) {
				e.printStackTrace(); return;
			}
			frame.setInnerPanel(ON_LOGIN);
		}
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

	@Override
	public void sendData(CodeType codeType, Data data) {
		switch (codeType)
		{
			// fetch socket to frame
			case ON_LOGIN -> frame.sendData(ON_LOGIN, data);
		}
	}

	@Override
	public void onReceiveData(Data data, WindowFrame frame) {
		frame.onReceiveData(data, frame);
	}


	private class LoginRoutineHandler extends RoutineHandler {

		public LoginRoutineHandler() {
			this.windowFrame = LoginUI.frame;
		}
	}
}

