package omok.LobbyUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class UserListPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private GridBagLayout gridBag;
	
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	public int userNum;
	
	public UserListPanel() {
		gridBag = new GridBagLayout();
		
		int[] rows = new int[16];
		Arrays.fill(rows, 36);
		gridBag.rowHeights = rows;
		setLayout(gridBag);
		
		setBackground(Color.white);
		JLabel title = new JLabel("UserList", SwingConstants.CENTER);
		
		cons = gbc(0, 0, 1, 1);
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor = GridBagConstraints.PAGE_START;
		gridBag.setConstraints(title, cons);
		add(title);
		
		addUser("Player1", false);
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
}
