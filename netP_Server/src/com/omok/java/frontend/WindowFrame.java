package com.omok.java.frontend;

import javax.swing.JFrame;
import java.awt.*;

public class WindowFrame extends JFrame implements Runnable {

	private ClientView view;

	public void setView(ClientView view) {
//		this.view.setVisible(false);
		this.view = view;
		this.view.setVisible(true);
	}

	public WindowFrame(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

//		JButton btn = new JButton("Action");
//		btn.addActionListener(new MyActionListener());
//		c.add(btn);

		setSize(300, 200);
		setVisible(true);
	}
	public WindowFrame(ClientView view) {

	}

	@Override
	public void run() {

	}
}
