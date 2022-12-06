package omok.LoginUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import omok.MainFrame;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel idLabel;

	private JTextField idTextField;
	
	private JButton loginBtn;
	
	private Image loginBackground;
	
	public LoginPanel(MainFrame m) {
		setLayout(null);
		ImageIcon backIcon = new ImageIcon("./image/mainbackground.jpg");
		loginBackground = backIcon.getImage();
		
		idLabel = new JLabel("닉네임");
		idLabel.setBounds(180, 200, 50, 30);
		//idLabel.setFont("");
		idTextField = new JTextField();
		idTextField.setBounds(230, 200, 100, 30);
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(340, 200, 70, 30);
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText().trim();
				
				if(id.length() == 0) {
					return;
				}
				
				m.changePanel();
				System.out.println(id);
			}
		});
		add(idLabel);
		add(idTextField);
		add(loginBtn);
	}
	
	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    if(loginBackground != null)
	    	g.drawImage(loginBackground, 0, 0, getWidth(), getHeight(), null);
	}
}
