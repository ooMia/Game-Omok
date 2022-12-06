package omok.GameUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

import omok.MainFrame;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// GridBagLayout
	private GridBagLayout gridBag;
	
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	// background
	private Image woodBackground;
	
	// Panels
	private GameLeftPanel leftPanel;
	private GameRightPanel rightPanel;
	
	public GamePanel(boolean isObserve) {
		// background
		ImageIcon backIcon = new ImageIcon("./image/mainbackground.jpg");
		woodBackground = backIcon.getImage();
		
		gridBag = new GridBagLayout();
		// column을 10개로 제한하고 각 크기를 94으로 설정\
		int[] columns = new int[10];
		Arrays.fill(columns, 94);
		gridBag.columnWidths = columns;
		setLayout(gridBag);
		
		leftPanel = new GameLeftPanel(isObserve);
		rightPanel = new GameRightPanel(isObserve);
		
		if(isObserve) {
			rightPanel.gameMenuPanel.showCount.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					leftPanel.changePanel();
				}
			});
		} else {
			rightPanel.gameMenuPanel.start.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					leftPanel.goBoardPanel.gameStart();
				}
			});
		}
		// UI 생성
		setUI();
	}

	private void setUI() {
		// left panel
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 0;		//그리드 x,y
		cons.gridy = 0;
		cons.gridwidth = 7;		// 70%
		cons.gridheight = 1;
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(10, 10, 10, 0);	// padding
		gridBag.setConstraints(leftPanel, cons);
        this.add(leftPanel);
        
        // right panel
        cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;;
		cons.gridx = 7;		// grid x,y
		cons.gridy = 0;
		cons.gridwidth = 3;		// 30%
		cons.gridheight = 1;
		cons.weightx = 1f;
		cons.weighty = 1f;
		cons.ipadx = 0;
		cons.ipady = 0;
		cons.anchor = GridBagConstraints.PAGE_START;
		cons.insets = new Insets(10, 10, 10, 10);	// padding
		gridBag.setConstraints(rightPanel, cons);
        this.add(rightPanel);
	}
	
	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    if(woodBackground != null)
	    	g.drawImage(woodBackground, 0, 0, getWidth(), getHeight(), null);
	}
}
