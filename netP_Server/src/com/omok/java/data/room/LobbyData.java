package com.omok.java.data.room;

import com.omok.java.backend.server.RoomManagingServer;
import com.omok.java.data.user.UserData;

import java.util.ArrayList;

public class LobbyData {
	private ArrayList<UserData> userDataList;
	private ArrayList<RoomData> userRoomList;

	public LobbyData(RoomManagingServer rms) {
		this.userDataList = rms.getServer().getClientList();
		this.userRoomList = rms.getServer().getRoomList();
	}
}
