package com.omok.Java.UI.Panel;

import com.omok.Java.Backend.Server.Server;
import com.omok.Java.UI.Panel.Structure.DefaultInnerPanel;

import javax.swing.*;
import java.awt.*;

public class GameRoomUI extends DefaultInnerPanel {

	public GameRoomUI(JPanel leftPanel, JPanel rightPanel, Image background, int[] gridBagColumnWidths) {
		super(leftPanel, rightPanel, background, gridBagColumnWidths);
		final Integer portNum = 30002;
		try {
			new Thread(new Server(portNum)).start();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
