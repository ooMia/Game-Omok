package omok.LobbyUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import omok.GameUI.GamePanel;

public class RoomPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image backgroundImage;
	
	private String roomTitle;
	private String roomID;
	private int userNum;
	
	private JLabel rIDLabel;
	private JLabel rTitleLabel;
	private JLabel uNumLabel;
	
	private JButton joinBtn;
	private JButton observerBtn;
	
	public RoomPanel(String rID, String rTitle, int uNum) {
		this.setPreferredSize(new Dimension(394, 60));
		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(null);
		ImageIcon backIcon = new ImageIcon("./image/room.png");
		backgroundImage = backIcon.getImage();
		
		rIDLabel = new JLabel(rID);
		rIDLabel.setBounds(60, 8, 100, 30);
		rTitleLabel = new JLabel(rTitle);
		rTitleLabel.setBounds(100, 8, 110, 30);
		uNumLabel = new JLabel(uNum + " / 2");
		uNumLabel.setBounds(225, 8, 100, 30);
		
		joinBtn = new JButton();
		joinBtn.setOpaque(false);
		joinBtn.setContentAreaFilled(false);
		joinBtn.setBorderPainted(false);
		joinBtn.setBounds(262, 2, 51, 19);
		observerBtn = new JButton();
		observerBtn.setOpaque(false);
		observerBtn.setContentAreaFilled(false);
		observerBtn.setBorderPainted(false);
		observerBtn.setBounds(262, 24, 51, 19);
		add(rIDLabel);
		add(rTitleLabel);
		add(uNumLabel);
		add(joinBtn);
		add(observerBtn);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// 위는 플레이어 아래는 옵저버
						if(joinBtn.equals(e.getSource()))
							joinRoom(false);
						else if(observerBtn.equals(e.getSource()))
							joinRoom(true);
					}
				});
			}
		};
		
		joinBtn.addActionListener(listener);
		observerBtn.addActionListener(listener);
	}
	
	private void joinRoom(boolean isObserve) {
		// 방 입장
		int mainFrameWidth = 940;
	    int mainFrameHeight = 780;
		JFrame f;
		f = new JFrame();
		Dimension mainDimension = new Dimension(mainFrameWidth, mainFrameHeight);
		f.setPreferredSize(mainDimension);
		f.setResizable(false);
		GamePanel p = new GamePanel(isObserve);
		
		f.add(p);
		f.setVisible(true);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 프로세스 남지 않게 종료
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    super.paintComponent(g2);
	    
	    if(backgroundImage != null)
	    	g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
