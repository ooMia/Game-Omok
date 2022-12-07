package omok.LobbyUI;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class RoomListPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Image backgroundImage;
	// layout
	private GridBagLayout gridBag;
	
	private GridBagConstraints cons;
	
	private JLabel title = new JLabel("¹æ ¸ñ·Ï");
	
	private int roomNum;
	
	public RoomListPanel() {
		//setBackground(Color.white);
		ImageIcon backIcon = new ImageIcon("./image/roomlist.png");
		backgroundImage = backIcon.getImage();
		gridBag = new GridBagLayout();
		roomNum = 0;
		
		int[] rows = new int[14];
		Arrays.fill(rows, 40);
		rows[0] = 20;
		gridBag.rowHeights = rows;
		
		int[] columns = new int[2];
		Arrays.fill(columns, 330);
		gridBag.columnWidths = columns;
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(gridBag);
		
		cons = gbc(0, 0, 2, 1);
		cons.fill = GridBagConstraints.VERTICAL;
		cons.anchor = GridBagConstraints.PAGE_START;
		gridBag.setConstraints(title, cons);
		add(title);

		addRoom("1234", "adw", 1);
		addRoom("4125", "www", 2);
		addRoom("6261", "gar", 2);
		addRoom("3213", "uawyerw", 1);
	}
	
	public void addRoom(String rID, String rName, int uNum) {
		cons = gbc(roomNum % 2, roomNum / 2 + 1, 1, 1);
		if(roomNum%2==0)
			cons.insets = new Insets(0, 5, 5, 2);
		else
			cons.insets = new Insets(0, 2, 5, 5);
		roomNum++;
		RoomPanel room1 = new RoomPanel(rID, rName, uNum);
		gridBag.setConstraints(room1, cons);
		add(room1);
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
