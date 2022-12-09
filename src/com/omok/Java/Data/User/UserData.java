package com.omok.Java.Data.User;

import com.omok.Java.Data.Data;
import com.omok.Java.Data.Room.RoomData;

import java.net.Socket;

public class UserData extends Data {
	public Socket userSocket;
	public RoomData userLocation;

	public UserData(Socket userSocket, RoomData userLocation) {
		this.userSocket = userSocket;
		this.userLocation = userLocation;
	}

	enum UserStatus {
		SLEEP_STATUS, WAKEUP_STATUS
	}
}

