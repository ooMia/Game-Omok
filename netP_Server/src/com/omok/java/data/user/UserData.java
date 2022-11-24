package com.omok.java.data.user;


import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class UserData implements Serializable {

	private Socket userSocket;
	public UserStatus userStatus;
	public String userName;

	public UserData(String hostIP, int hostPort, String u1) throws IOException {
		this.userStatus = UserStatus.ON_LINE;
		this.userName = u1;
		this.userSocket = new Socket(hostIP, hostPort);
	}
}

