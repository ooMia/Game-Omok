package omok.LobbyUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class UserListPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image backgroundImage;
	
	private GridBagLayout gridBag;
	
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	public int userNum;
	
	public UserListPanel() {
		gridBag = new GridBagLayout();
		
		ImageIcon backIcon = new ImageIcon("./image/roomlist.png");
		backgroundImage = backIcon.getImage();
		int[] rows = new int[16];
		Arrays.fill(rows, 36);
		rows[0] = 30;
		gridBag.rowHeights = rows;
		setLayout(gridBag);
		
		//setBackground(Color.white);
		JLabel title = new JLabel("UserList", SwingConstants.CENTER);
		
		cons = gbc(0, 0, 1, 1);
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor = GridBagConstraints.PAGE_START;
		gridBag.setConstraints(title, cons);
		add(title);
		
		addUser("Player1", false);
		addUser("Player2", true);
	}
	
	public void addUser(String uName, boolean s) {
		userNum++;
		cons = gbc(0, userNum, 1, 1);
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(0, 5, 5, 5);
		UserPanel u = new UserPanel(uName, s);
		gridBag.setConstraints(u, cons);
		add(u);
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
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    super.paintComponent(g2);
	    
	    if(backgroundImage != null)
	    	g2.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
