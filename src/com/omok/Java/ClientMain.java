package com.omok.Java;

import com.omok.Java.Data.CodeType;
import com.omok.Java.UI.Frame.ClientFrame;

public class ClientMain {
	public static void main(String[] args)
	{
		ClientFrame clientFrame = new ClientFrame("LoginUI");
		clientFrame.setInnerPanel(CodeType.ON_START);
	}
}
