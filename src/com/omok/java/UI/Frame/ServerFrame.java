package com.omok.Java.UI.Frame;

import com.omok.Java.Backend.Server.Server;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.awt.*;

public class ServerFrame extends WindowFrame {

	public ServerFrame(String title, Dimension size) {
		super(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(size);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
