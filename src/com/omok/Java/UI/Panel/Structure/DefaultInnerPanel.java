package com.omok.Java.UI.Panel.Structure;

import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.awt.*;

public abstract class DefaultInnerPanel extends InnerPanel {

	private JPanel leftPanel;
	private JPanel rightPanel;
	private GridBagConstraints consLeftPanel;
	private GridBagConstraints consRightPanel;

	private Image woodBackground;
	private GridBagLayout gridBag;

	public DefaultInnerPanel(WindowFrame windowFrame, JPanel leftPanel, JPanel rightPanel, Image background, int[] gridBagColumnWidths) {
		super(windowFrame);

		this.leftPanel = leftPanel;
		this.rightPanel = rightPanel;
		this.consLeftPanel = new GridBagConstraints();
		this.consRightPanel = new GridBagConstraints();

		this.woodBackground = background;
		this.gridBag = new GridBagLayout();;
		gridBag.columnWidths = gridBagColumnWidths;
		setLayout(gridBag);

		setUI();
	}

	protected void setUI() {
		// left panel
		consLeftPanel.fill = GridBagConstraints.BOTH;
		consLeftPanel.gridx = 0;		//그리드 x,y
		consLeftPanel.gridy = 0;
		consLeftPanel.gridwidth = 7;		// 70%
		consLeftPanel.gridheight = 1;
		consLeftPanel.weightx = 1f;
		consLeftPanel.weighty = 1f;
		consLeftPanel.ipadx = 0;
		consLeftPanel.ipady = 0;
		consLeftPanel.anchor = GridBagConstraints.PAGE_START;
		consLeftPanel.insets = new Insets(10, 10, 10, 0);	// padding

		gridBag.setConstraints(leftPanel, consLeftPanel);
		this.add(leftPanel);

		// right panel
		consRightPanel.fill = GridBagConstraints.BOTH;;
		consRightPanel.gridx = 7;		// grid x,y
		consRightPanel.gridy = 0;
		consRightPanel.gridwidth = 3;		// 30%
		consRightPanel.gridheight = 1;
		consRightPanel.weightx = 1f;
		consRightPanel.weighty = 1f;
		consRightPanel.ipadx = 0;
		consRightPanel.ipady = 0;
		consRightPanel.anchor = GridBagConstraints.PAGE_START;
		consRightPanel.insets = new Insets(10, 10, 10, 10);	// padding
		gridBag.setConstraints(rightPanel, consRightPanel);
		this.add(rightPanel);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(woodBackground != null)
			g.drawImage(woodBackground, 0, 0, getWidth(), getHeight(), null);
	}

}
