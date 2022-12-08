package com.omok.java.frontend.omok.GameUI;

import javax.swing.*;
import java.awt.*;

public class GameChatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// ä�ñ���
	private JTextArea chatArea;
	private JScrollPane scroll;
	
	// ������ ��
	private JTextArea sendArea;
	private JButton sendBtn;
	
	private JPanel southPanel;
	
	public GameChatPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		//setBorder(BorderFactory.createLineBorder(Color.black));
		
		// TextArea
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		scroll = new JScrollPane(chatArea);
		scroll.setBorder(BorderFactory.createLineBorder(Color.black));
		
		southPanel = new JPanel(new BorderLayout());
		
		sendArea = new JTextArea();
		sendArea.setEditable(true);
		sendArea.setBorder(BorderFactory.createLineBorder(Color.black));
		sendBtn = new JButton("Send");
		
		southPanel.add(sendArea, BorderLayout.CENTER);
		southPanel.add(sendBtn, BorderLayout.EAST);
		
		add(southPanel, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
	}
}
