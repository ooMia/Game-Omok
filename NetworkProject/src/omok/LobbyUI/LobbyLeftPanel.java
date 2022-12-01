package omok.LobbyUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LobbyLeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// layout
	private GridBagLayout gridBag;
	
	// background
	private Image woodBackground;
	
	// Constraints for GridBag set
	private GridBagConstraints cons;
	// Panels
	private JPanel roomListPanel = new RoomListPanel();
	private JPanel chatPanel = new LobbyChatPanel();
	
	public LobbyLeftPanel() {
		// background
		ImageIcon backIcon = new ImageIcon("./image/mainbackground.jpg");
		woodBackground = backIcon.getImage();
		
		gridBag = new GridBagLayout();
		// rows�� 10���� �����ϰ� �� ũ�⸦ 72�� ����
		int[] rows = new int[10];
		Arrays.fill(rows, 72);
		gridBag.rowHeights = rows;
		setLayout(gridBag);
		
		setUI();
	}
		
	private void setUI() {
		// goBoardPanel add
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;	// grid x,y
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 8;	// 80%
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		//cons.insets = new Insets(10, 0, 0, 0);
		gridBag.setConstraints(roomListPanel, cons);
	    this.add(roomListPanel);
	        
	    // chatPanel add
	    cons = new GridBagConstraints();
	    cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;	// grid xy
		cons.gridy = 8;
		cons.gridwidth = 1;
		cons.gridheight = 2;
		cons.weightx = 1f;	// percentage
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(10, 0, 0, 0);	// margin
		gridBag.setConstraints(chatPanel, cons);
	    this.add(chatPanel);
	}
	
	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    if(woodBackground != null)
	    	g.drawImage(woodBackground, 0, 0, 1000, 780, null);
	}
}
