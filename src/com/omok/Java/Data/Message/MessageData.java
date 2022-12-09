package com.omok.Java.Data.Message;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;

import java.net.Socket;

public abstract class MessageData extends Data {

	public String message;

	public MessageData(CodeType codeType, Socket senderSocket, Socket receiverSocket, String message) {
		super(codeType, senderSocket, receiverSocket);
		this.message = message;
	}
}
