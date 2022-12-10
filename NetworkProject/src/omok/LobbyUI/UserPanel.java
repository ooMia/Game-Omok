package omok.LobbyUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.*;

public class UserPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image background;
	
	private boolean sleep;

	private JLabel userName;
	private JLabel userStatus;
	private JButton dmBtn;
	
	public UserPanel(String uName, boolean s) {
		this.setLayout(null);
		ImageIcon backIcon = new ImageIcon("./image/user.png");
		background = backIcon.getImage();
		
		userName = new JLabel(uName);
		// user status from data
		userStatus = new JLabel("online");
		if(s)
			userStatus.setText(" sleep");
		dmBtn = new JButton();
		dmBtn.setOpaque(false);
		dmBtn.setContentAreaFilled(false);
		dmBtn.setBorderPainted(false);
		
		userName.setBounds(65, 10, 100, 15);
		userStatus.setBounds(10, 10, 50, 15);
		dmBtn.setBounds(184, 6, 41, 22);
		add(userName);
		add(userStatus);
		add(dmBtn);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    super.paintComponent(g2);
	    if(background != null)
	    	g2.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
