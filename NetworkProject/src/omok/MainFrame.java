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
	private final String FRAME_TITLE = "����";
	private int mainFrameWidth = 940;
    private int mainFrameHeight = 780;
	private int loginFrameWidth = 600;
    private int loginFrameHeight = 400;
    
    // JFrame Container
    private Container c;
    
    // JPanel
    private JPanel mainPanel;
    
    // Dimension, ������ â ũ��
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
		// ������ â �߾� ����
		setLocationRelativeTo(null);
		
		// �α���
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
