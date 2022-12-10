package com.omok.Java.UI.Panel.Lobby;


import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class LobbyRightPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private GridBagLayout gridBag;
	private Image woodBackground;
	private GridBagConstraints cons;
	private JPanel userList;
	private JPanel playerInfo;
	
	public LobbyRightPanel() {
		ImageIcon backIcon = new ImageIcon("./image/mainbackground.jpg");
		woodBackground = backIcon.getImage();
		
		gridBag = new GridBagLayout();
		int[] rows = new int[10];
		Arrays.fill(rows, 72);
		gridBag.rowHeights = rows;
		setLayout(gridBag);
		
		this.setLayout(gridBag);
		
		userList = new UserListPanel();
		playerInfo = new PlayerInfoPanel();
		
		setUI();
	}
	
	private void setUI() {
		// userListPanel add
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;	// grid xy
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 8;
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		gridBag.setConstraints(userList, cons);
		this.add(userList);
		        
		// playerInfoPanel add
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;	// grid xy
		cons.gridy = 8;
		cons.gridwidth = 1;
		cons.gridheight = 2;
		cons.weightx = 1f;	// percentage
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(10, 0, 0, 0);	// margin
		gridBag.setConstraints(playerInfo, cons);
		//playerInfo.setBackground(Color.white);
		//playerInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(playerInfo);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    super.paintComponent(g2);
	    if(woodBackground != null)
	    	g2.drawImage(woodBackground, 0, 0, 1000, 780, null);
	}
}
