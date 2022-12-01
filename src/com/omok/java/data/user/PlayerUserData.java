package com.omok.java.data.user;

import java.io.IOException;

// PlayerUserData: UserData whom in a RoomData
public abstract class PlayerUserData extends UserData{


	public PlayerUserData(String userName) throws IOException {
		super(userName);
	}
}
