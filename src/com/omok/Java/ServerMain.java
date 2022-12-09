package com.omok.Java;

import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Frame.ServerFrame;
import com.omok.Java.UI.Panel.GameRoomUI;
import com.omok.Java.UI.Panel.Gameroom.GameLeftPanel;
import com.omok.Java.UI.Panel.Gameroom.GameRightPanel;
import com.omok.Java.UI.Panel.LoginUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ServerMain {
	public static void main(String[] args) {

//		new Thread(new ServerFrame(
//				"HostConfigurePanel",
//				new Dimension(500, 900)
//		)).start();

		ServerFrame f = new ServerFrame(
				"HostConfigurePanel",
				new Dimension(940, 780)
		);

		int GameRoomUI_columns[] = new int[10];
		Arrays.fill(GameRoomUI_columns, 94);
		InnerPanel p = new GameRoomUI(
				new GameLeftPanel(true),
				new GameRightPanel(true),
				new ImageIcon("./image/mainbackground.jpg").getImage(),
				GameRoomUI_columns
		);
		p.setFrame(f);
		f.setInnerPanel(p);
		f.setVisible(true);

	}

}

// ������ �����ϴ� ��� ������κ��� �г����� key������ ���� �����͸� �����Ѵ�.
// accept �� socket�� ���������� ����Ǹ�

