package com.omok.java.data.user;

import java.io.IOException;

public abstract class GamePlayerUserData extends PlayerUserData{

	public GamePlayerUserData(String userName) throws IOException {
		super(userName);
	}
}
