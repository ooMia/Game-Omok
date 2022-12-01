package data.message;

import data.CodeType;
import data.Data;

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
