package com.omok.Java.Data.Room;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import java.net.Socket;

public abstract class RoomData extends Data {
	public InnerPanel innerPanel;

	public RoomData(CodeType codeType, Socket senderSocket, Socket receiverSocket, InnerPanel innerPanel) {
		super(codeType, senderSocket, receiverSocket);
		this.innerPanel = innerPanel;
	}
}
