package com.omok.Java.UI.Panel.Lobby;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class UserPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private boolean sleep;

	private JLabel userName;
	private JLabel userStatus;
	private JButton dmBtn;
	
	public UserPanel(String uName, boolean s) {
		this.setLayout(null);
		userName = new JLabel(uName);
		// user status from data
		userStatus = new JLabel("online");
		if(s)
			userStatus.setText("sleep");
		dmBtn = new JButton("±Ó¼Ó¸»");
		
		userName.setBounds(80, 10, 50, 15);
		userStatus.setBounds(15, 10, 50, 15);
		dmBtn.setBounds(150, 6, 75, 20);
		add(userName);
		add(userStatus);
		add(dmBtn);
	}
}
