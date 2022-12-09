package com.omok.Java;

import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Frame.ServerFrame;
import com.omok.Java.UI.Panel.GameRoomUI;
import com.omok.Java.UI.Panel.Gameroom.GameLeftPanel;
import com.omok.Java.UI.Panel.Gameroom.GameRightPanel;
import com.omok.Java.UI.Panel.LoginUI;
import com.omok.Java.UI.Panel.ServerLogUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ServerMain {
	public static void main(String[] args)
	{
		ServerFrame f = new ServerFrame(
				"HostConfigurePanel",
				new Dimension(338, 440)
		);
		InnerPanel p = new ServerLogUI();
		p.setFrame(f);
		f.setInnerPanel(p);
		f.setVisible(true);
	}
}
