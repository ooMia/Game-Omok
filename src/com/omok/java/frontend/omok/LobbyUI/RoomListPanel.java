package com.omok.java.frontend.omok.LobbyUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class RoomListPanel extends JPanel {

	// layout
	private GridBagLayout gridBag;
	
	private GridBagConstraints cons;
	
	private JLabel title = new JLabel("RooomList");
	
	public RoomListPanel() {
		setBackground(Color.white);
		gridBag = new GridBagLayout();
		
		int[] rows = new int[7];
		Arrays.fill(rows, 100);
		rows[0] = 50;
		gridBag.rowHeights = rows;
		
		int[] columns = new int[2];
		Arrays.fill(columns, 330);
		gridBag.columnWidths = columns;
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(gridBag);
		
		cons = gbc(0, 0, 2, 1);
		cons.fill = GridBagConstraints.VERTICAL;
		cons.anchor = GridBagConstraints.PAGE_START;
		gridBag.setConstraints(title, cons);
		add(title);
		cons = gbc(0, 1, 1, 1);
		cons.insets = new Insets(0, 5, 0, 5);	// margin
		RoomPanel room1 = new RoomPanel();
		gridBag.setConstraints(room1, cons);
		add(room1);
		cons =  gbc(1, 1, 1, 1);
		cons.insets = new Insets(0, 5, 0, 5);	// margin
		RoomPanel room2 = new RoomPanel();
		gridBag.setConstraints(room2, cons);
		add(room2);
	}
	
	private GridBagConstraints gbc(int x, int y, int w, int h) {
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = x;	// grid x,y
		cons.gridy = y;
		cons.gridwidth = w;		// percentage
		cons.gridheight = h;
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		//cons.anchor = GridBagConstraints.PAGE_START;
		cons.anchor = GridBagConstraints.NORTH;
		return cons;
	}
}
