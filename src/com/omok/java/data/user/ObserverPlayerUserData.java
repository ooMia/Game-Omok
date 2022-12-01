package com.omok.java.data.user;

import java.io.IOException;

public class ObserverPlayerUserData extends PlayerUserData{
	private PlayerUserData playerUserDataInfo;

	public ObserverPlayerUserData(String userName) throws IOException {
		super(userName);
	}
}
