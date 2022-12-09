package com.omok.Java.UI.Panel;

import com.omok.Java.Data.Data;
import com.omok.Java.Data.User.UserData;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class ServerLogUI extends InnerPanel {

	private JPanel contentPane;
	JTextArea textArea;
	private JTextField txtPortNumber;

	private ServerSocket serverSocket;

	private ArrayList<UserData> userConnected; // ����� ����� ���


	public ServerLogUI(
			ServerSocket serverSocket,
			ArrayList<UserData> userConnected,
	) {
		this.serverSocket = serverSocket;
		this.userConnected = userConnected;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		btnServerStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new ServerSocket(Integer.parseInt(txtPortNumber.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				AppendText("Chat Server Running..");
				btnServerStart.setText("Chat Server Running..");
				btnServerStart.setEnabled(false); // ������ ���̻� �����Ű�� �� �ϰ� ���´�
				txtPortNumber.setEnabled(false); // ���̻� ��Ʈ��ȣ ������ �ϰ� ���´�
				AcceptServer accept_server = new AcceptServer();
				accept_server.start();
			}
		});
		btnServerStart.setBounds(12, 356, 300, 35);
		contentPane.add(btnServerStart);
	}

	// ���ο� ������ accept() �ϰ� user thread�� ���� �����Ѵ�.
	class AcceptServer extends Thread {

		public void run() {
			while (true) {
				try {
					AppendText("Waiting new clients ...");
					client_socket = socket.accept();

					AppendText("���ο� ������ from " + client_socket);
					UserService new_user = new UserService(client_socket);
					UserVec.add(new_user);
					new_user.start();
					AppendText("���� ������ �� " + UserVec.size());
				} catch (IOException e) {
					AppendText("accept() error");
				}
			}
		}
	}

	private void AppendText(String str) {
		textArea.append(String.format("%s\n", str));
		textArea.setCaretPosition(textArea.getText().length());
	}
	public void AppendObject(Data data) {
		textArea.append(String.format("%s\n", data.toString()));
		textArea.setCaretPosition(textArea.getText().length());
	}

	// User �� �����Ǵ� Thread
	// Read One ���� ��� -> Write All
	class UserService extends Thread {
		private ObjectInputStream ois;
		private ObjectOutputStream oos;

		private Socket client_socket;
		private Vector<UserService> user_vc;
		public String UserName = "";
		public String UserStatus;

		public UserService(Socket client_socket) {
			// �Ű������� �Ѿ�� �ڷ� ����
			this.client_socket = client_socket;
			this.user_vc = UserVec;
			try {
				oos = new ObjectOutputStream(client_socket.getOutputStream());
				oos.flush();
				ois = new ObjectInputStream(client_socket.getInputStream());
			} catch (Exception e) {
				AppendText("userService error");
			}
		}

		public void Login() {
			AppendText("���ο� ������ " + UserName + " ����.");
			WriteOne("Welcome to Java chat server\n");
			WriteOne(UserName + "�� ȯ���մϴ�.\n"); // ����� ����ڿ��� ���������� �˸�
			String msg = "[" + UserName + "]���� ���� �Ͽ����ϴ�.\n";
			WriteOthers(msg); // ���� user_vc�� ���� ������ user�� ���Ե��� �ʾҴ�.
		}

		public void Logout() {
			String msg = "[" + UserName + "]���� ���� �Ͽ����ϴ�.\n";
			UserVec.removeElement(this); // Logout�� ���� ��ü�� ���Ϳ��� �����
			WriteAll(msg); // ���� ������ �ٸ� User�鿡�� ����
			this.client_socket = null;
			AppendText("����� " + "[" + UserName + "] ����. ���� ������ �� " + UserVec.size());
		}

		// ��� User�鿡�� ���. ������ UserService Thread�� WriteONe() �� ȣ���Ѵ�.
		public void WriteAll(String str) {
			for (int i = 0; i < user_vc.size(); i++) {
				UserService user = (UserService) user_vc.elementAt(i);
				if (user.UserStatus == "O")
					user.WriteOne(str);
			}
		}
		// ��� User�鿡�� Object�� ���. ä�� message�� image object�� ���� �� �ִ�
		public void WriteAllObject(ChatMsg obj) {
			for (int i = 0; i < user_vc.size(); i++) {
				UserService user = (UserService) user_vc.elementAt(i);
				if (user.UserStatus == "O")
					user.WriteChatMsg(obj);
			}
		}

		// ���� ������ User�鿡�� ���. ������ UserService Thread�� WriteONe() �� ȣ���Ѵ�.
		public void WriteOthers(String str) {
			for (int i = 0; i < user_vc.size(); i++) {
				UserService user = (UserService) user_vc.elementAt(i);
				if (user != this && user.UserStatus == "O")
					user.WriteOne(str);
			}
		}

		// Windows ó�� message ������ ������ �κ��� NULL �� ����� ���� �Լ�
		public byte[] MakePacket(String msg) {
			byte[] packet = new byte[BUF_LEN];
			byte[] bb = null;
			int i;
			for (i = 0; i < BUF_LEN; i++)
				packet[i] = 0;
			try {
				bb = msg.getBytes("euc-kr");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			for (i = 0; i < bb.length; i++)
				packet[i] = bb[i];
			return packet;
		}

		// UserService Thread�� ����ϴ� Client ���� 1:1 ����
		public void WriteOne(String msg) {
			ChatMsg obcm = new ChatMsg("SERVER", "200", msg);
			WriteChatMsg(obcm);
		}

		// �ӼӸ� ����
		public void WritePrivate(String msg) {
			ChatMsg obcm = new ChatMsg("�ӼӸ�", "200", msg);
			WriteChatMsg(obcm);
		}
		//
		public void WriteChatMsg(ChatMsg obj) {
			try {
				oos.writeObject(obj.code);
				oos.writeObject(obj.UserName);
				oos.writeObject(obj.data);
				if (obj.code.equals("300")) {
					oos.writeObject(obj.imgbytes);
					//oos.writeObject(obj.bimg);
				}
			}
			catch (IOException e) {
				AppendText("oos.writeObject(ob) error");
				try {
					ois.close();
					oos.close();
					client_socket.close();
					client_socket = null;
					ois = null;
					oos = null;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Logout();

			}
		}

		public ChatMsg ReadChatMsg() {
			Object obj = null;
			String msg = null;
			ChatMsg cm = new ChatMsg("", "", "");
			// Android�� ȣȯ���� ���� ������ Field�� ���ε��� �д´�.
			try {
				obj = ois.readObject();
				cm.code = (String) obj;
				obj = ois.readObject();
				cm.UserName = (String) obj;
				obj = ois.readObject();
				cm.data = (String) obj;
				if (cm.code.equals("300")) {
					obj = ois.readObject();
					cm.imgbytes = (byte[]) obj;
//					obj = ois.readObject();
//					cm.bimg = (BufferedImage) obj;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				Logout();
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Logout();
				return null;
			}
			return cm;
		}
		public void run() {
			while (true) { // ����� ������ ����ؼ� �ޱ� ���� while��
				ChatMsg cm = null;
				if (client_socket == null)
					break;
				cm = ReadChatMsg();
				if (cm==null)
					break;
				if (cm.code.length()==0)
					break;
				AppendObject(cm);
				if (cm.code.matches("100")) {
					UserName = cm.UserName;
					UserStatus = "O"; // Online ����
					Login();
				} else if (cm.code.matches("200")) {
					String msg = String.format("[%s] %s", cm.UserName, cm.data);
					AppendText(msg); // server ȭ�鿡 ���
					String[] args = msg.split(" "); // �ܾ���� �и��Ѵ�.
					if (args.length == 1) { // Enter key �� ���� ��� Wakeup ó���� �Ѵ�.
						UserStatus = "O";
					} else if (args[1].matches("/exit")) {
						Logout();
						break;
					} else if (args[1].matches("/list")) {
						WriteOne("User list\n");
						WriteOne("Name\tStatus\n");
						WriteOne("-----------------------------\n");
						for (int i = 0; i < user_vc.size(); i++) {
							UserService user = (UserService) user_vc.elementAt(i);
							WriteOne(user.UserName + "\t" + user.UserStatus + "\n");
						}
						WriteOne("-----------------------------\n");
					} else if (args[1].matches("/sleep")) {
						UserStatus = "S";
					} else if (args[1].matches("/wakeup")) {
						UserStatus = "O";
					} else if (args[1].matches("/to")) { // �ӼӸ�
						for (int i = 0; i < user_vc.size(); i++) {
							UserService user = (UserService) user_vc.elementAt(i);
							if (user.UserName.matches(args[2]) && user.UserStatus.matches("O")) {
								String msg2 = "";
								for (int j = 3; j < args.length; j++) {// ���� message �κ�
									msg2 += args[j];
									if (j < args.length - 1)
										msg2 += " ";
								}
								// /to ����.. [�ӼӸ�] [user1] Hello user2..
								user.WritePrivate(args[0] + " " + msg2 + "\n");
								//user.WriteOne("[�ӼӸ�] " + args[0] + " " + msg2 + "\n");
								break;
							}
						}
					} else { // �Ϲ� ä�� �޽���
						UserStatus = "O";
						//WriteAll(msg + "\n"); // Write All
						WriteAllObject(cm);
					}
				} else if (cm.code.matches("400")) { // logout message ó��
					Logout();
					break;
				} else if (cm.code.matches("300")) {
					WriteAllObject(cm);
				}
			} // while
		} // run
	}
}
