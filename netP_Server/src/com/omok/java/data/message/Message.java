package com.omok.java.data.message;

import com.omok.java.data.CodeType;
import com.omok.java.data.Data;
import com.omok.java.data.user.UserData;

public class Message implements Data {

	private CodeType code;
	private Data data;

	public Message(CodeType code, Data data) {
		this.code = code;
		this.data = data;
	}


	@Override
	public void defineBehavior(CodeType code) {

	}

	@Override
	public Data getUnpackedData(CodeType code, Data data) {
		return null;
	}
}
