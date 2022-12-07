package omok.LoginUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import omok.MainFrame;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image loginBackground;
	
	private JTextField idTextField;
	private JButton loginBtn;
	private MainFrame m;
	
	public LoginPanel(MainFrame m) {
		this.m = m;
		setLayout(null);
		ImageIcon backIcon = new ImageIcon("./image/logint.png");
		loginBackground = backIcon.getImage();

		idTextField = new JTextField();
		idTextField.setBounds(240, 328, 150, 30);
		loginBtn = new JButton();
		loginBtn.setOpaque(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setBorderPainted(false);
		loginBtn.setBounds(400, 328, 70, 30);
		
		idTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					tryLogin();
				}
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tryLogin();
			}
		});
		add(idTextField);
		add(loginBtn);
	}
	
	public void tryLogin() {
		String id = idTextField.getText().trim();
		
		if(id.length() == 0) {
			return;
		}
		
		m.changePanel();
		System.out.println(id);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    super.paintComponent(g2);
	    if(loginBackground != null)
	    	g2.drawImage(loginBackground, 0, 0, null);
	}
}
