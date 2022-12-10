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

	public LobbyLeftPanel lobbyLeftPanel;
	public LobbyRightPanel lobbyRightPanel;

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
		this.lobbyLeftPanel = new LobbyLeftPanel();
		this.lobbyRightPanel = new LobbyRightPanel();
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
		try {
			CodeType codeType = (CodeType) this.frame.ois.readObject();
			switch (codeType){
				case CREATE_ROOM -> {
					String p1 = (String) this.frame.ois.readObject();
					String p2 = (String) this.frame.ois.readObject();
					int p3 = (int) this.frame.ois.readObject();
					LobbyLeftPanel.roomListPanel.addRoom(p1, p2, p3);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


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

