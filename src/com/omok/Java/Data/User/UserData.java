package com.omok.Java.Data.User;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;

public class UserData extends Data
{
	public String nickname;
	public CodeType status;

	public UserData(CodeType codeType, String nickname, CodeType status) {
		super(codeType);
		this.nickname = nickname;
		this.status = status;
	}
}

