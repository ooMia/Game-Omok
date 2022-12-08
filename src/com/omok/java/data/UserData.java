package com.omok.Java.Data;


import com.omok.Java.Data.Room.RoomData;

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

