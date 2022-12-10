package com.omok.Java.UI.Panel;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Panel.Lobby.LobbyLeftPanel;
import com.omok.Java.UI.Panel.Lobby.LobbyRightPanel;
import com.omok.Java.UI.Panel.Structure.DefaultInnerPanel;

public class LobbyUI extends DefaultInnerPanel {

	public LobbyUI(ClientFrame clientFrame) {
		super(
				clientFrame,
				new LobbyLeftPanel(),
				new LobbyRightPanel(),
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

