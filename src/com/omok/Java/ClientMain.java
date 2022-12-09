package com.omok.Java;

import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Panel.LoginUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import java.awt.*;

public class ClientMain {
	public static void main(String[] args)
	{
		ClientFrame clientFrame = new ClientFrame("LoginUI");
		InnerPanel p = new LoginUI(clientFrame);
		clientFrame.setPreferredSize(new Dimension(626, 418));
		clientFrame.setInnerPanel(p);
		clientFrame.setVisible(true);
	}
}
