package com.omok.Java.UI.Panel;

import com.omok.Java.Backend.Service.RoutineHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.ServerMain;
import com.omok.Java.UI.Frame.ServerFrame;
import com.omok.Java.UI.Panel.Structure.InnerPanel;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLogUI extends InnerPanel
{
	private ServerSocket serverSocket = ServerMain.serverSocket;
	public static ServerFrame frame;

	private JPanel contentPane;
	JTextArea textArea;
	private JTextField txtPortNumber;


	public ServerLogUI(ServerFrame serverFrame)
	{
		super(serverFrame);
		this.frame = serverFrame;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		serverFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

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
			ServerMain.run(); // 등록된 Server 루틴 실행
			serverLog("Server Running..");
			btnServerStart.setText("Server Running..");
			btnServerStart.setEnabled(false);
			txtPortNumber.setEnabled(false);
		});
		btnServerStart.setBounds(12, 356, 300, 35);
		contentPane.add(btnServerStart);
	}




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
	public void onReceiveData(Data data, WindowFrame frame) {

	}


	public static class ServerRoutineHandler extends RoutineHandler
	{
		public static Socket socket;
		public static ObjectOutputStream oos;
		public static ObjectInputStream ois;
		public static String nickname;
		public static ServerFrame frame;

		public ServerRoutineHandler(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) throws IOException, ClassNotFoundException {
			this.frame = ServerLogUI.frame;
			this.socket = socket;
			this.oos = oos;
			this.ois = ois;
			this.nickname = (String) ois.readObject();
		}

		@Override
		public void run() {
			super.run();

			System.out.println(this.getClass().toString() + "\tSTART");

			while (ServerMain.clientThreadGroup.activeCount() >= 0)
			{
				System.out.println(this.getClass() + "\tWAITING FOR INPUTS...");
				try {
					System.out.println(this.getClass().toString() + ois.readObject().toString());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			System.out.println(this.getClass() + "\tEND");
		}


	}

}
