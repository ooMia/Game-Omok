package com.omok.Java.UI.Panel.Lobby;


import java.awt.Color;

import javax.swing.*;

public class PlayerInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel playerName;
	
	public PlayerInfoPanel() {
		setBackground(Color.white);
		playerName = new JLabel("PlayerName");
		add(playerName);
	}
}
