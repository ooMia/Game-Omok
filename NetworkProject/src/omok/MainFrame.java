package omok;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

import backend.NetworkService;
import omok.GameUI.GamePanel;
import omok.LobbyUI.LobbyPanel;
import omok.LoginUI.LoginPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// window setting
	private final String FRAME_TITLE = "오목";
	private int FRAME_WIDTH = 940;
    private int FRAME_HEIGHT = 780;
    //private int FRAME_LOC_X = 20;
    //private int FRAME_LOC_Y = 20;
    
    // JFrame Container
    private Container c;
    
    // JPanel
    private JPanel gamePanel;
    
    // Dimension, 윈도우 창 크기
    private Dimension mainDimension;
    private Dimension loginDimension;
    
    private Socket socket;
    private NetworkService listenNetwork;
    
	public MainFrame(String ipAddr, String portNo) {
		setTitle(FRAME_TITLE);
		loginDimension = new Dimension(600, 400);
		mainDimension = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
		setPreferredSize(loginDimension);
		//setMinimumSize(mainDimension);
		setResizable(false);
		pack();
		// 윈도우 창 중앙 생성
		//setLocation(FRAME_LOC_X, FRAME_LOC_Y);
		setLocationRelativeTo(null);
		
		gamePanel = new LoginPanel();
		c = getContentPane();
		c.add(gamePanel);
		
		try {
			socket = new Socket(ipAddr, Integer.parseInt(portNo));
			listenNetwork = new NetworkService(socket);
			//listenNetwork.run();	
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// lobby <<-->> gameroom panel change
	private void changePanel() {
		
	}
}
