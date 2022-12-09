package com.omok.Java.Data;

import java.io.Serializable;

public abstract class Data implements Serializable {
	public CodeType codeType;

	public Data(CodeType codeType) {
		this.codeType = codeType;
	}
}
