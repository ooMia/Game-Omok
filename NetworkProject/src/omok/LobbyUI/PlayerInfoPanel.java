package omok.LobbyUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.*;

public class PlayerInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Image backgroundImage;
	
	private JLabel playerName;
	
	public PlayerInfoPanel() {
		ImageIcon backIcon = new ImageIcon("./image/roomlist.png");
		backgroundImage = backIcon.getImage();
		//setBackground(Color.white);
		playerName = new JLabel("PlayerName");
		add(playerName);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    super.paintComponent(g2);
	    
	    if(backgroundImage != null)
	    	g2.drawImage(backgroundImage, 0, 0, this.getWidth(), 600, this);
	}
}
