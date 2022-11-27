package com.omok.java.data.user;


import com.omok.java.data.CodeType;
import com.omok.java.data.Data;

import java.io.IOException;

public class UserData implements Data {

	public UserStatus userStatus;
	public String userName;

	public UserData(String hostIP, int hostPort, String u1) throws IOException {
		this.userStatus = UserStatus.ON_LINE;
		this.userName = u1;
	}

	@Override
	public Data getUnpackedData(CodeType code, Data data) {
		return null;
	}

	@Override
	public void defineBehavior(CodeType code) {

	}
}

