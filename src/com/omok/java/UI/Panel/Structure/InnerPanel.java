package com.omok.Java.UI.Panel.Structure;

import com.omok.Java.Data.CodeType;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// only one InnerPanel can be shown above for each WindowFrame
// can change InnerPanel by calling function setView() in WindowFrame
public class InnerPanel extends JPanel {

	private WindowFrame frame;

	public void setFrame(WindowFrame frame) {
		this.frame = frame;
	}

	public void setSocket(Socket socket) { this.frame.setSocket(socket); }
	public Socket getSocket(){ return this.frame.getSocket(); }

	public void updateInnerPanel(CodeType c) {
		switch (c){
			case LOGIN_STATUS -> frame.setInnerPanel(c);
		}
	}

	protected ObjectInputStream getOIS() {
		return frame.getOIS();
	}
	protected ObjectOutputStream getOOS() {
		return frame.getOOS();
	}
}
