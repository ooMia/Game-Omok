package omok.LoginUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel idLabel;

	private JTextField idTextField;
	
	private JButton loginBtn;
	
	public LoginPanel() {
		setLayout(null);
		idLabel = new JLabel("닉네임");
		idLabel.setBounds(100, 200, 50, 30);
		//idLabel.setFont("");
		idTextField = new JTextField();
		idTextField.setBounds(150, 200, 100, 30);
		loginBtn = new JButton("로그인");
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
