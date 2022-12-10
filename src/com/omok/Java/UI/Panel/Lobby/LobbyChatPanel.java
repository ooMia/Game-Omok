package com.omok.Java.UI.Panel.Lobby;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Panel.LobbyUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;
import com.omok.Java.UI.WindowFrame;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.*;

public class LobbyChatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image woodBackground;
	// 채팅구역
	private JTextArea chatArea;
	private JScrollPane scroll;
		
	// 보내는 곳
	private JTextArea sendArea;
	private JButton sendBtn;
	
	// 위치지정용
	private JPanel southPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;

	// 버튼
	private JButton refreshList;
	public JButton createRoom;
	private JButton directJoin;
	
	public LobbyChatPanel() {

		ImageIcon backIcon = new ImageIcon("./image/mainbackground.jpg");
		woodBackground = backIcon.getImage();
		
		setLayout(new BorderLayout(5,5));
		//setBackground(Color.white);
		//setBorder(BorderFactory.createLineBorder(Color.black));
		
		setUI();
	}
	
	private void setUI() {
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
		
		leftPanel = new JPanel(new BorderLayout());
		
		leftPanel.add(southPanel, BorderLayout.SOUTH);
		leftPanel.add(scroll, BorderLayout.CENTER);
		
		add(leftPanel, BorderLayout.CENTER);
		
		// 새로고침, 방 만들기, 바로가기
		rightPanel = new JPanel(new GridLayout(3, 0, 0, 10)) {
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g)
			{
			    super.paintComponent(g);
			    if(woodBackground != null)
			    	g.drawImage(woodBackground, 0, 0, 1000, 780, null);
			}
		};
		
		refreshList = new JButton("새로고침");
		createRoom = new JButton("방만들기");
		directJoin = new JButton("바로가기");

		AtomicInteger i = new AtomicInteger();
		createRoom.addActionListener(e -> {

		});



		rightPanel.add(refreshList);
		rightPanel.add(createRoom);
		rightPanel.add(directJoin);
		
		add(rightPanel, BorderLayout.EAST);
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
