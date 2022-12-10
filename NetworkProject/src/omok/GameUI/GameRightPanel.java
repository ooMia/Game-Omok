package omok.GameUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class GameRightPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image background;
	// layout
	private GridBagLayout gridBag;
	
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	// Panes
	public GameMenuPanel gameMenuPanel;
	private CharacterPanel characterPanel;
	private JPanel tempPanel = new JPanel();
	
	public GameRightPanel(boolean isObserve) {
		background = new ImageIcon("./image/background2.png").getImage();
		
		gridBag = new GridBagLayout();
		setBorder(BorderFactory.createLineBorder(Color.black));
		int[] rows = new int[10];
		Arrays.fill(rows, 72);
		gridBag.rowHeights = rows;
		setLayout(gridBag);
		
		characterPanel = new CharacterPanel();
		gameMenuPanel = new GameMenuPanel(isObserve);
		
		this.setLayout(gridBag);
		
		setUI();
	}
	
	private void setUI() {
		// characterPanel add
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;	// grid xy
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 5;
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(5, 5, 5, 5);	// margin
		gridBag.setConstraints(characterPanel, cons);
        this.add(characterPanel);
        
        // menu add
        cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;	// grid xy
		cons.gridy = 5;
		cons.gridwidth = 1;
		cons.gridheight = 2;
		cons.weightx = 1f;	// percentage
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(0, 5, 0, 5);	// margin
		gridBag.setConstraints(gameMenuPanel, cons);
		//gameMenuPanel.setBackground(Color.white);
		//gameMenuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(gameMenuPanel);
        
        // Panel add
        cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;	// grid xy
		cons.gridy = 7;
		cons.gridwidth = 1;
		cons.gridheight = 3;
		cons.weightx = 1f;	// percentage
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(5, 5, 5, 5);	// margin
		gridBag.setConstraints(tempPanel, cons);
		tempPanel.setBackground(Color.white);
		tempPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(tempPanel);
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
