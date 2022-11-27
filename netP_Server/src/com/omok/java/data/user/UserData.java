package com.omok.java.data.user;


import com.omok.java.data.CodeType;
import com.omok.java.data.Data;

import java.io.IOException;

public class UserData implements Data {

	public UserStatus userStatus;
	public final String userName;

	public UserData(String u1) throws IOException {
		this.userStatus = UserStatus.ON_LINE;
		this.userName = u1;
	}

	@Override
	public Data getUnpackedData(CodeType code, Data data) {
		return null;
	}

	@Override
	public Object definedBehavior(CodeType code) {
		switch (code)
		{
			case LOGIN_STATUS -> {

				getUnpackedData(null, null);

				this.userStatus = UserStatus.ON_LINE;
				return null;
			}
			default -> { return null; }
		}
	}
}

