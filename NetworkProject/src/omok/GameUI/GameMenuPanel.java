package omok.GameUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class GameMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// layout
	private GridBagLayout gridBag;
			
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	// Buttons
	private JButton ready;
	private JButton start;
	private JButton surrender;
	private JButton withdraw;
	private JButton a;
	
	public GameMenuPanel() {
		// set layout
		gridBag = new GridBagLayout();
		int[] rows = new int[12];
		Arrays.fill(rows, 6);
		gridBag.rowHeights = rows;
		int[] columns = new int[3];
		Arrays.fill(columns, 100);
		gridBag.columnWidths = columns;
		setLayout(gridBag);
		
		ready = new JButton("준비");
		start = new JButton("시작");
		surrender = new JButton("항복");
		withdraw = new JButton("무르기");

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
}
