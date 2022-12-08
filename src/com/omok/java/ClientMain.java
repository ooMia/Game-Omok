package com.omok.Java;

import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Panel.LoginUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import java.awt.*;

public class ClientMain {
	public static void main(String[] args) {

		ClientFrame f = new ClientFrame(
				"LoginUI",
				new Dimension(626, 418)
		);
		InnerPanel p = new LoginUI();
		p.setFrame(f);
		f.setInnerPanel(p);
		f.setVisible(true);

//
//
//		ClientFrame lobby = new ClientFrame(
//				"LobbyUI",
//				new Dimension(940, 780)
//		);
//
//		int LobbyUI_columns[] = new int[10];
//		Arrays.fill(LobbyUI_columns, 100);
//		lobby.setInnerPanel(
//				new LobbyUI(
//						new LobbyLeftPanel(),
//						new LobbyRightPanel(),
//						new ImageIcon("./image/mainbackground.jpg").getImage(),
//						LobbyUI_columns
//				)
//		);
//		new Thread(lobby).start();
//
//
//
//
//
//		ClientFrame gameroom = new ClientFrame(
//				"GameroomUI",
//				new Dimension(940, 780)
//		);
//
//		int GameRoomUI_columns[] = new int[10];
//		Arrays.fill(GameRoomUI_columns, 94);
//		gameroom.setInnerPanel(
//				new GameRoomUI(
//						new GameLeftPanel(false),
//						new GameRightPanel(false),
//						new ImageIcon("./image/mainbackground.jpg").getImage(),
//						GameRoomUI_columns
//				)
//		);
//		new Thread(gameroom).start();

	}
}
