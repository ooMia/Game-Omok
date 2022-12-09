package com.omok.Java;

import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Panel.LoginUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import java.awt.*;

public class ClientMain {
	public static void main(String[] args)
	{
		ClientFrame f = new ClientFrame(
				"LoginUI",
				new Dimension(626, 418)
		);
		InnerPanel p = new LoginUI();
		p.setFrame(f);
		f.setInnerPanel(p);
		f.setVisible(true);
	}
}
