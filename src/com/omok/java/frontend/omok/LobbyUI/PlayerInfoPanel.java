package com.omok.java.frontend.omok.LobbyUI;

import java.awt.Color;

import javax.swing.*;

public class PlayerInfoPanel extends JPanel {

	private JLabel playerName;
	
	public PlayerInfoPanel() {
		setBackground(Color.white);
		playerName = new JLabel("PlayerName");
		add(playerName);
	}
}
