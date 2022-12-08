package com.omok.java.frontend.omok.LoginUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel {

	private JLabel idLabel;

	private JTextField idTextField;
	
	private JButton loginBtn;
	
	public LoginPanel() {
		setLayout(null);
		idLabel = new JLabel("NickName");
		idLabel.setBounds(100, 200, 50, 30);
		//idLabel.setFont("");
		idTextField = new JTextField();
		idTextField.setBounds(150, 200, 100, 30);
		loginBtn = new JButton("Login");
		loginBtn.setBounds(260, 200, 50, 30);
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText().trim();
				
				if(id.length() == 0) {
					return;
				}
				
				System.out.println(id);
			}
		});
		
		add(idLabel);
		add(idTextField);
		add(loginBtn);
	}
}
