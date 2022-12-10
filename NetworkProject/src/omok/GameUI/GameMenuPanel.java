package omok.GameUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class GameMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image background;
	private ImageIcon readyIcon;
	private ImageIcon startIcon;
	private ImageIcon surrenderIcon;
	private ImageIcon withdrawIcon;
	// layout
	private GridBagLayout gridBag;
			
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	// Buttons
	private JButton ready;
	public JButton start;
	private JButton surrender;
	private JButton withdraw;
	// 수순
	public JButton showCount;
	
	public GameMenuPanel(boolean isObserve) {
		readyIcon = new ImageIcon("./image/readybutton.png");
		startIcon = new ImageIcon("./image/startbutton.png");
		surrenderIcon = new ImageIcon("./image/surrenderbutton.png");
		withdrawIcon = new ImageIcon("./image/withdrawbutton.png");
		background = new ImageIcon("./image/background2.png").getImage();
		// set layout
		gridBag = new GridBagLayout();
		int[] rows = new int[12];
		Arrays.fill(rows, 6);
		gridBag.rowHeights = rows;
		int[] columns = new int[3];
		Arrays.fill(columns, 100);
		gridBag.columnWidths = columns;
		setLayout(gridBag);
		
		setButton();

		cons = gbc(0, 0, 1, 2);
		cons.insets = new Insets(5, 5, 5, 5);
		gridBag.setConstraints(ready, cons);
		add(ready);

		cons = gbc(1, 0, 1, 2);
		cons.insets = new Insets(5, 5, 5, 5);
		gridBag.setConstraints(start, cons);
		add(start);
		
		cons = gbc(2, 0, 1, 2);
		cons.insets = new Insets(5, 5, 5, 5);
		gridBag.setConstraints(surrender, cons);
		add(surrender);
		
		cons = gbc(0, 2, 1, 2);
		cons.insets = new Insets(5, 5, 5, 5);
		gridBag.setConstraints(withdraw, cons);
		add(withdraw);
		
		if(isObserve) {
			showCount = new JButton("수순");
			cons = gbc(1, 2, 1, 2);
			cons.insets = new Insets(5, 5, 5, 5);
			gridBag.setConstraints(showCount, cons);
			add(showCount);
		}
	}
	
	public void setButton() {
		ready = new JButton("준비") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(readyIcon != null)
			    	g2.drawImage(readyIcon.getImage(), 0, 0, this);
			}
		};
		ready.setOpaque(false);
		ready.setContentAreaFilled(false);
		ready.setBorderPainted(false);
		
		start = new JButton("시작") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(startIcon != null)
			    	g2.drawImage(startIcon.getImage(), 0, 0, this);
			}
		};
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		
		surrender = new JButton("항복") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(surrenderIcon != null)
			    	g2.drawImage(surrenderIcon.getImage(), 0, 0, this);
			}
		};
		surrender.setOpaque(false);
		surrender.setContentAreaFilled(false);
		surrender.setBorderPainted(false);
		
		withdraw = new JButton("무르기") {
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				super.paintComponent(g2);
				
			    if(withdrawIcon != null)
			    	g2.drawImage(withdrawIcon.getImage(), 0, 0, this);
			}
		};
		withdraw.setOpaque(false);
		withdraw.setContentAreaFilled(false);
		withdraw.setBorderPainted(false);
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
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		super.paintComponent(g2);
		
	    if(background != null)
	    	g2.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
