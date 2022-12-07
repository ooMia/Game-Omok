package omok.GameUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class CharacterPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// layout
	private GridBagLayout gridBag;
		
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	// profile image
	private ImageIcon masterImgIcon;
	private ImageIcon slaveImgIcon;
	private JLabel masterImg;
	private JLabel slaveImg;
	
	private JLabel masterName;
	private JLabel slaveName;
	
	private JLabel masterStat;
	private JLabel slaveStat;
	
	public CharacterPanel() {
		// set layout
		gridBag = new GridBagLayout();
		int[] rows = new int[35];
		Arrays.fill(rows, 10);
		gridBag.rowHeights = rows;
		int[] columns = new int[2];
		Arrays.fill(columns, 100);
		gridBag.columnWidths = columns;
		setLayout(gridBag);
		
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		masterImgIcon = new ImageIcon(new ImageIcon("./image/defaultprofile.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
		slaveImgIcon = new ImageIcon(new ImageIcon("./image/defaultprofile.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
	    
		masterImg = new JLabel();
		masterImg.setIcon(masterImgIcon);
		slaveImg = new JLabel();
		slaveImg.setIcon(slaveImgIcon);
		
		masterName = new JLabel("player1", SwingConstants.CENTER);
		masterName.setFont(new Font(masterName.getFont().getName(), masterName.getFont().getStyle(), 20));
		slaveName = new JLabel("player2", SwingConstants.CENTER);
		slaveName.setFont(new Font(slaveName.getFont().getName(), slaveName.getFont().getStyle(), 20));
		
		masterImg.setBorder(BorderFactory.createLineBorder(Color.black));
		slaveImg.setBorder(BorderFactory.createLineBorder(Color.black));

		setProfileImg();
		setProfileName();
		setPlayerStat();
	}
	
	private void setProfileImg() {
		cons = gbc(0, 0, 1, 12);
		cons.insets = new Insets(2, 2, 5, 0);
		gridBag.setConstraints(masterImg, cons);
        this.add(masterImg);
        
        cons = gbc(1, 0, 1, 12);
		cons.insets = new Insets(2, 0, 5, 2);
		gridBag.setConstraints(slaveImg, cons);
        this.add(slaveImg);
	}
	
	private void setProfileName() {
		cons = gbc(0, 12, 1, 3);
		
		//cons.insets = new Insets(0, 5, 5, 0);
		gridBag.setConstraints(masterName, cons);
        this.add(masterName);
        
        cons = gbc(1, 12, 1, 3);
		//cons.insets = new Insets(0, 5, 5, 0);
		
		gridBag.setConstraints(slaveName, cons);
        this.add(slaveName);
	}
	
	public void setPlayerStat() {
		cons = gbc(0, 17, 1, 3);
		masterStat = new JLabel("0Àü 0½Â 0ÆÐ", SwingConstants.CENTER);
		masterStat.setFont(new Font(masterStat.getFont().getName(), masterStat.getFont().getStyle(), 18));
		gridBag.setConstraints(masterStat, cons);
        this.add(masterStat);
		
		cons = gbc(1, 17, 1, 3);
		slaveStat = new JLabel("0Àü 0½Â 0ÆÐ", SwingConstants.CENTER);
		slaveStat.setFont(new Font(slaveStat.getFont().getName(), slaveStat.getFont().getStyle(), 18));
		gridBag.setConstraints(slaveStat, cons);
        this.add(slaveStat);
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
	}
}
