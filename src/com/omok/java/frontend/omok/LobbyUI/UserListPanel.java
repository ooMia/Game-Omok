package com.omok.java.frontend.omok.LobbyUI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class UserListPanel extends JPanel {

	public UserListPanel() {
		setBackground(Color.white);
		add(new JLabel("UserList", SwingConstants.CENTER));
	}
}