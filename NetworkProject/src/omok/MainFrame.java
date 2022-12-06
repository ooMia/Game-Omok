package omok;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

import backend.NetworkService;
import omok.GameUI.GamePanel;
import omok.LobbyUI.LobbyPanel;
import omok.LoginUI.LoginPanel;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// window setting
	private final String FRAME_TITLE = "오목";
	private int mainFrameWidth = 940;
    private int mainFrameHeight = 780;
	private int loginFrameWidth = 600;
    private int loginFrameHeight = 400;
    
    // JFrame Container
    private Container c;
    
    // JPanel
    private JPanel mainPanel;
    
    // Dimension, 윈도우 창 크기
    private Dimension mainDimension;
    private Dimension loginDimension;
    
    private Socket socket;
    private NetworkService listenNetwork;
    
	public MainFrame(String ipAddr, String portNo) {
		setTitle(FRAME_TITLE);
		loginDimension = new Dimension(loginFrameWidth, loginFrameHeight);
		mainDimension = new Dimension(mainFrameWidth, mainFrameHeight);
		setPreferredSize(loginDimension);
		//setPreferredSize(mainDimension);
		
		//setMinimumSize(mainDimension);
		setResizable(false);
		pack();
		// 윈도우 창 중앙 생성
		setLocationRelativeTo(null);
		
		// 로그인
		mainPanel = new LoginPanel(this);
		c = getContentPane();
		c.add(mainPanel);
	}
	
	// lobby <<-->> gameroom panel change
	public void changePanel() {
		this.remove(mainPanel);
		mainPanel = new LobbyPanel();
		this.setSize(mainDimension);
		this.setPreferredSize(mainDimension);
		this.setLocationRelativeTo(null);
		this.add(mainPanel);
		this.pack();
		repaint();
	}
}
