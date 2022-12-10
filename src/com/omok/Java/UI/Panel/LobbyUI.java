package com.omok.Java.UI.Panel;

import com.omok.Java.Backend.Service.RoutineHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Panel.Lobby.LobbyLeftPanel;
import com.omok.Java.UI.Panel.Lobby.LobbyRightPanel;
import com.omok.Java.UI.Panel.Structure.DefaultInnerPanel;
import com.omok.Java.UI.WindowFrame;

public class LobbyUI extends DefaultInnerPanel {

	public static ClientFrame frame;
	public LobbyUI(ClientFrame clientFrame) {
		super(
				clientFrame,
				new LobbyLeftPanel(),
				new LobbyRightPanel(),
				null,
				null
		);
		this.frame = clientFrame;
	}

	@Override
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data, WindowFrame frame) {

	}

	private class LobbyRoutineHandler extends RoutineHandler {

		public LobbyRoutineHandler() {
			this.windowFrame = LobbyUI.frame;
		}
	}

}

