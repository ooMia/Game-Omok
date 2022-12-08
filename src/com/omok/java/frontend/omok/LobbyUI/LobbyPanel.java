package com.omok.java.frontend.omok.LobbyUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class LobbyPanel extends JPanel {

	// GridBagLayout
	private GridBagLayout gridBag;
		
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	// background
	private Image woodBackground;
		
	// Panels
	private JPanel leftPanel;
	private JPanel rightPanel;
		
	public LobbyPanel() {
		// background
		ImageIcon backIcon = new ImageIcon("./image/mainbackground.jpg");
		woodBackground = backIcon.getImage();
		
		
		gridBag = new GridBagLayout();
		// column�� 10���� �����ϰ� �� ũ�⸦ 100���� ����\
		int[] columns = new int[10];
		Arrays.fill(columns, 100);
		gridBag.columnWidths = columns;
		setLayout(gridBag);
		
		leftPanel = new LobbyLeftPanel();
		rightPanel = new LobbyRightPanel();
		// UI ����
		setUI();
	}
	
	private void setUI() {
		// left panel
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;		//�׸��� x,y
		cons.gridy = 0;
		cons.gridwidth = 7;		// 70%
		cons.gridheight = 1;
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(10, 10, 10, 0);	// padding
		gridBag.setConstraints(leftPanel, cons);
		this.add(leftPanel);
		        
		// right panel
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 7;		// grid x,y
		cons.gridy = 0;
		cons.gridwidth = 3;		// 30%
		cons.gridheight = 1;
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(10, 10, 10, 10);	// padding
		gridBag.setConstraints(rightPanel, cons);
		this.add(rightPanel);
	}
	
	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    if(woodBackground != null)
	    	g.drawImage(woodBackground, 0, 0, getWidth(), getHeight()+100, null);
	}
}
