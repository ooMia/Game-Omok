package com.omok.java.data.user;

import com.omok.java.data.room.RoomData;

import java.io.IOException;

// PlayerUserData: UserData whom in a RoomData
public abstract class PlayerUserData extends UserData{


	public PlayerUserData(Integer userID, RoomData userLocation) {
		super(userID, userLocation);
	}
}
