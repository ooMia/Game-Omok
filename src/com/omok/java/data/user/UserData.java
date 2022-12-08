package com.omok.java.data.user;


import com.omok.java.data.Data;
import com.omok.java.data.room.RoomData;




public class UserData extends Data {
	public Integer userID;
	public RoomData userLocation;

	public UserData(Integer userID, RoomData userLocation) {
		this.userID = userID;
		this.userLocation = userLocation;
	}

	enum UserStatus {
		SLEEP_STATUS, WAKEUP_STATUS
	}
}

