package omok.LobbyUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

import omok.GameUI.GamePanel;

public class LobbyPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// GridBagLayout
	private GridBagLayout gridBag;
		
	// Constraints for GridBag set
	private GridBagConstraints cons;
	
	// background
	private Image woodBackground;
		
	// Panels
	private LobbyLeftPanel leftPanel;
	private LobbyRightPanel rightPanel;
	
	// dialog
	private JDialog dialog;
	
	
	public LobbyPanel(JFrame m) {
		// background
		ImageIcon backIcon = new ImageIcon("./image/mainbackground.jpg");
		woodBackground = backIcon.getImage();
		
		
		gridBag = new GridBagLayout();
		// column을 10개로 제한하고 각 크기를 100으로 설정\
		int[] columns = new int[10];
		Arrays.fill(columns, 100);
		gridBag.columnWidths = columns;
		setLayout(gridBag);
		
		leftPanel = new LobbyLeftPanel();
		rightPanel = new LobbyRightPanel();
		
		dialog = new JDialog(m, "방 설정");
		setDialog();
		
		leftPanel.chatPanel.createRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(true);
			}
		});
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
	
	public void setDialog() {
		dialog.setSize(250, 200);
		dialog.setLayout(null);
		dialog.setLocationRelativeTo(null);
		
		JLabel nameLabel = new JLabel("방이름");
		JTextField nameField = new JTextField();
		JButton okBtn = new JButton("만들기");
		
		nameLabel.setBounds(18, 10, 100, 30);
		nameField.setBounds(65, 10, 150, 30);
		okBtn.setBounds(130, 80, 80, 30);
		
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String roomName = nameField.getText().trim();
				System.out.println(roomName + " 생성");
				
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// 위는 플레이어 아래는 옵저버
						makeRoom();
					}
				});
				
				dialog.setVisible(false);
				nameField.setText("");
			}
		});
		
		dialog.add(nameLabel);
		dialog.add(nameField);
		dialog.add(okBtn);
	}
	
	public void makeRoom() {
		int mainFrameWidth = 940;
	    int mainFrameHeight = 780;
		JFrame f;
		f = new JFrame();
		Dimension mainDimension = new Dimension(mainFrameWidth, mainFrameHeight);
		f.setPreferredSize(mainDimension);
		f.setResizable(false);
		GamePanel p = new GamePanel(false);
		
		f.add(p);
		f.setVisible(true);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 프로세스 남지 않게 종료
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    super.paintComponent(g2);
	    if(woodBackground != null)
	    	g2.drawImage(woodBackground, 0, 0, getWidth(), getHeight()+100, null);
	}
}
