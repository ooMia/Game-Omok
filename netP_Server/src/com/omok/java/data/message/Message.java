package com.omok.java.data.message;

import com.omok.java.data.CodeType;
import com.omok.java.data.Data;

public class Message implements Data {

	private final CodeType code;
	private final Data data;

	public Message(CodeType code, Data data) {
		this.code = code;
		this.data = data;
	}


	@Override
	public Object definedBehavior(CodeType code) {
return null;
	}

	@Override
	public Data getUnpackedData(CodeType code, Data data) {
		return null;
	}
}
