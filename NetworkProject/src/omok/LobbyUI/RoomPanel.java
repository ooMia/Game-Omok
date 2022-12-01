package omok.LobbyUI;

import java.awt.Dimension;

import javax.swing.*;

public class RoomPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private String roomTitle;
	private int roomID;
	private int userNum;
	
	private JLabel rIDLabel;
	private JLabel rTitleLabel;
	private JLabel uNumLabel;
	private JLabel sLabel;
	
	private JButton joinBtn;
	
	public RoomPanel() {
		this.setPreferredSize(new Dimension(333, 100));
		rIDLabel = new JLabel("1234");
		rTitleLabel = new JLabel("roomname");
		uNumLabel = new JLabel("1 / 2");
		joinBtn = new JButton("입장하기");
		add(rIDLabel);
		add(rTitleLabel);
		add(uNumLabel);
		add(joinBtn);
	}
}
