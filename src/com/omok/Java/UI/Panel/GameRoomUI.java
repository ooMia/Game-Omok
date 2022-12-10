package com.omok.Java.UI.Panel;

import com.omok.Java.Backend.Server.Server;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Panel.Gameroom.GameLeftPanel;
import com.omok.Java.UI.Panel.Gameroom.GameRightPanel;
import com.omok.Java.UI.Panel.Lobby.LobbyLeftPanel;
import com.omok.Java.UI.Panel.Lobby.LobbyRightPanel;
import com.omok.Java.UI.Panel.Structure.DefaultInnerPanel;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.awt.*;

public class GameRoomUI extends DefaultInnerPanel {

	public GameRoomUI(WindowFrame windowFrame, JPanel leftPanel, JPanel rightPanel, Image background, int[] gridBagColumnWidths) {
		super(windowFrame, leftPanel, rightPanel, background, gridBagColumnWidths);
	}

	public GameRoomUI(ClientFrame clientFrame, boolean modeObserver) {
		super(
				clientFrame,
				new GameLeftPanel(modeObserver),
				new GameRightPanel(modeObserver),
				null,
				null
		);
	}


	@Override
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data) {

	}
}
