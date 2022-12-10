package com.omok.Java.UI.Panel;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.Backend.Service.RoutineHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Frame.ClientFrame;
import com.omok.Java.UI.Panel.Lobby.LobbyLeftPanel;
import com.omok.Java.UI.Panel.Lobby.LobbyRightPanel;
import com.omok.Java.UI.Panel.Lobby.RoomPanel;
import com.omok.Java.UI.Panel.Structure.DefaultInnerPanel;
import com.omok.Java.UI.WindowFrame;

import java.io.IOException;

public class LobbyUI extends DefaultInnerPanel {

	public static LobbyLeftPanel lobbyLeftPanel = new LobbyLeftPanel();
	public static LobbyRightPanel lobbyRightPanel = new LobbyRightPanel();

	public static ClientFrame frame;
	public LobbyUI(ClientFrame clientFrame) {
		super(
				clientFrame,
				lobbyLeftPanel,
				lobbyRightPanel,
				null,
				null
		);
		this.frame = clientFrame;
	}

	@Override
	public void sendData(CodeType codeType, Data data) {

		switch (codeType){
			case TO_ALL_USER -> {}
			case TO_EXCEPT_USER -> {}
			case TO_MEMBERS_USER -> {}
			case TO_SOME_USER -> {}
			case TO_OTHERS_USER -> {}
			case TO_ONE_USER -> {}
			default -> { new LobbyRoutineHandler(data.obj).start(); }
		}

	}

	@Override
	public void onReceiveData(Data data, WindowFrame frame) {

	}


	public static class LobbyRoutineHandler extends RoutineHandler implements DataHandler {
		protected ClientFrame frame;
		public LobbyRoutineHandler(Object obj) {
			frame = LobbyUI.frame;
		}

		@Override
		public void run() {
			super.run();
			while(true)
			{
				try {
					onReceiveData((Data) frame.ois.readObject(), frame);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}


		@Override
		public void sendData(CodeType codeType, Data data) {}

		@Override
		public void onReceiveData(Data data, WindowFrame frame) {

		}

		public void onReceiveData(Data data, LobbyUI frame) {
			if (data.obj instanceof RoomPanel){
				LobbyLeftPanel.roomListPanel.addRoom((RoomPanel)(data.obj));
			}

		}
	}

}

