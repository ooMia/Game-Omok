package omok.GameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameChatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// 채팅구역
	private JTextArea chatArea;
	private JScrollPane scroll;
	
	// 보내는 곳
	private JTextArea sendArea;
	private JButton sendBtn;
	
	private JPanel southPanel;
	
	public GameChatPanel() {
		ImageIcon sendIcon = new ImageIcon("./image/sendBtn.png");
		
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
		//sendArea.setBorder(BorderFactory.createLineBorder(Color.black));
		sendArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String chat = sendArea.getText().trim();
					if(chat.equals("")) return;
					
					sendChat(chat);
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
				
			    if(sendIcon != null)
			    	g2.drawImage(sendIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
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
		
		southPanel.add(jsp, BorderLayout.CENTER);
		southPanel.add(sendBtn, BorderLayout.EAST);
		
		add(southPanel, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
	}
	
	public void sendChat(String c) {
		
	}
	
	public void appendText(String c) {
		int len = chatArea.getDocument().getLength();
		chatArea.setCaretPosition(len);
		chatArea.replaceSelection(c + "\n");
	}
}
