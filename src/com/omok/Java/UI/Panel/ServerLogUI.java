package com.omok.Java.UI.Panel;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.ServerMain;
import com.omok.Java.UI.Panel.Structure.InnerPanel;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerLogUI extends InnerPanel
{
	private ServerSocket serverSocket = ServerMain.serverSocket;

	public ServerLogUI(WindowFrame windowFrame)
	{
		super(windowFrame);

		contentPane.setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 300, 298);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JLabel lblNewLabel = new JLabel("Port Number");
		lblNewLabel.setBounds(13, 318, 87, 26);
		contentPane.add(lblNewLabel);

		txtPortNumber = new JTextField();
		txtPortNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPortNumber.setText("30000");
		txtPortNumber.setBounds(112, 318, 199, 26);
		contentPane.add(txtPortNumber);
		txtPortNumber.setColumns(10);

		JButton btnServerStart = new JButton("Server Start");
		btnServerStart.addActionListener(e -> {
			try {
				socket = new ServerSocket(Integer.parseInt(txtPortNumber.getText()));
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			serverLog("Chat Server Running..");
			btnServerStart.setText("Chat Server Running..");
			btnServerStart.setEnabled(false); // 서버를 더이상 실행시키지 못 하게 막는다
			txtPortNumber.setEnabled(false); // 더이상 포트번호 수정못 하게 막는다
//			AcceptServer accept_server = new AcceptServer();
//			accept_server.start();
		});
		btnServerStart.setBounds(12, 356, 300, 35);
		contentPane.add(btnServerStart);
	}


	private JPanel contentPane;
	JTextArea textArea;
	private JTextField txtPortNumber;

	private void serverLog(String str) {
		textArea.append(String.format("%s\n", str));
		textArea.setCaretPosition(textArea.getText().length());
	}
	public void serverLog(Data data) {
		textArea.append(String.format("%s\n", data.toString()));
		textArea.setCaretPosition(textArea.getText().length());
	}

	@Override
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data) {

	}


	class UserService extends Thread
	{
		private ObjectInputStream ois;
		private ObjectOutputStream oos;

		private Socket client_socket;
		private Vector<UserService> user_vc;

		public String UserName = "";
		public String UserStatus;


		// 유저의 콘솔로 출력
		private void sendData(String str) {
			System.out.println(str);
		}

		// sender -> (data) -> receiver
		public void sendData(Data data) {
			switch (data.codeType){
				case TO_ALL_USER -> {}
				case TO_EXCEPT_USER -> {}
				case TO_MEMBERS_USER -> {}
				case TO_OTHERS_USER -> {}
				case TO_SOME_USER -> {}
				case TO_ONE_USER -> {}
				default -> { sendData("UNDEFINED MESSAGE TYPE: " + data.toString()); }
			}
		}

		//		public void Login() {		}

//		public void Logout() {		}

		// 귓속말 전송
//		public void WritePrivate(String msg) {		}

//		public void WriteChatMsg(Data data) {		}

//		public Data ReadChatMsg() {		}

		public void run() {

		} // run
	}
}
