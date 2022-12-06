package omok.LobbyUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import omok.GameUI.GamePanel;

public class RoomPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private String roomTitle;
	private String roomID;
	private int userNum;
	
	private JLabel rIDLabel;
	private JLabel rTitleLabel;
	private JLabel uNumLabel;
	private JLabel sLabel;
	
	private JButton joinBtn;
	private JButton observerBtn;
	
	public RoomPanel(String rID, String rTitle, int uNum) {
		this.setPreferredSize(new Dimension(333, 100));
		this.setLayout(null);
		rIDLabel = new JLabel(rID);
		rIDLabel.setBounds(30, 10, 100, 30);
		rTitleLabel = new JLabel(rTitle);
		rTitleLabel.setBounds(80, 10, 80, 30);
		uNumLabel = new JLabel(uNum + " / 2");
		uNumLabel.setBounds(180, 10, 100, 30);
		joinBtn = new JButton("입장");
		joinBtn.setBounds(240, 8, 60, 30);
		observerBtn = new JButton("관전");
		observerBtn.setBounds(240, 42, 60, 30);
		add(rIDLabel);
		add(rTitleLabel);
		add(uNumLabel);
		add(joinBtn);
		add(observerBtn);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// 위는 플레이어 아래는 옵저버
						if(joinBtn.equals(e.getSource()))
							joinRoom(false);
						else if(observerBtn.equals(e.getSource()))
							joinRoom(true);
					}
				});
			}
		};
		
		joinBtn.addActionListener(listener);
		observerBtn.addActionListener(listener);
	}
	
	private void joinRoom(boolean isObserve) {
		// 방 입장
		int mainFrameWidth = 940;
	    int mainFrameHeight = 780;
		JFrame f;
		f = new JFrame();
		Dimension mainDimension = new Dimension(mainFrameWidth, mainFrameHeight);
		f.setPreferredSize(mainDimension);
		f.setResizable(false);
		GamePanel p = new GamePanel(isObserve);
		
		f.add(p);
		f.setVisible(true);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 프로세스 남지 않게 종료
	}
}
