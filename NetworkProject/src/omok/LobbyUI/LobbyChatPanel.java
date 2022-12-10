package omok.LobbyUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class LobbyChatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image woodBackground;
	private Image chatBackground;
	private Image sendBtnImg;
	private ImageIcon refreshIcon;
	private ImageIcon makeIcon;
	private ImageIcon directIcon;
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
		ImageIcon chatIcon = new ImageIcon("./image/background2.png");
		ImageIcon sendIcon = new ImageIcon("./image/sendBtn.png");
		refreshIcon = new ImageIcon("./image/refreshbutton.png");
		makeIcon = new ImageIcon("./image/makeroombutton.png");
		directIcon = new ImageIcon("./image/directbutton.png");
		
		chatBackground = chatIcon.getImage();
		woodBackground = backIcon.getImage();
		sendBtnImg = sendIcon.getImage();
		
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
		
		sendArea = new JTextArea();
		sendArea.setEditable(true);
		//sendArea.setBorder(BorderFactory.createLineBorder(Color.black));
		sendArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String chat = sendArea.getText().trim();
					if(chat.equals("")) return;
					
					appendText(chat);
					sendArea.setText("");
					sendArea.requestFocus();
				}
			}
		});
		JScrollPane jsp = new JScrollPane(sendArea);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		sendBtn = new JButton("Send") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(sendBtnImg != null)
			    	g2.drawImage(sendBtnImg, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		sendBtn.setOpaque(false);
		sendBtn.setContentAreaFilled(false);
		sendBtn.setBorderPainted(false);
		sendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String chat = sendArea.getText().trim();
				if(chat.equals("")) return;
				
				sendChat(chat);
				appendText(chat);
				sendArea.setText("");
				sendArea.requestFocus();
			}
			
		});
		
		southPanel = new JPanel(new BorderLayout());
		southPanel.add(jsp, BorderLayout.CENTER);
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
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			    super.paintComponent(g2);
			    if(woodBackground != null)
			    	g2.drawImage(woodBackground, -500, -500, 1000, 780, null);
			}
		};
		
		setButton();
		
		rightPanel.add(refreshList);
		rightPanel.add(createRoom);
		rightPanel.add(directJoin);
		
		add(rightPanel, BorderLayout.EAST);
	}
	
	public void setButton() {
		refreshList = new JButton("새로고침") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(refreshIcon != null)
			    	g2.drawImage(refreshIcon.getImage(), 0, 0, this);
			}
		};
		refreshList.setOpaque(false);
		refreshList.setContentAreaFilled(false);
		refreshList.setBorderPainted(false);
		
		createRoom = new JButton("방만들기") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(makeIcon != null)
			    	g2.drawImage(makeIcon.getImage(), 0, 0, this);
			}
		};
		createRoom.setOpaque(false);
		createRoom.setContentAreaFilled(false);
		createRoom.setBorderPainted(false);
		
		directJoin = new JButton("바로가기") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(makeIcon != null)
			    	g2.drawImage(directIcon.getImage(), 0, 0, this);
			}
		};
		directJoin.setOpaque(false);
		directJoin.setContentAreaFilled(false);
		directJoin.setBorderPainted(false);
	}
	
	public void sendChat(String c) {
		
	}

	public void appendText(String c) {
		int len = chatArea.getDocument().getLength();
		chatArea.setCaretPosition(len);
		chatArea.replaceSelection(c + "\n");
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
