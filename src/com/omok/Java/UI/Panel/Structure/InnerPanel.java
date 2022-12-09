package com.omok.Java.UI.Panel.Structure;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static com.omok.Java.Data.CodeType.LOGIN_STATUS;

// only one InnerPanel can be shown above for each WindowFrame
// can change InnerPanel by calling function setView() in WindowFrame
public class InnerPanel extends JPanel implements DataHandler {

	private WindowFrame frame;

	public void setFrame(WindowFrame frame) {
		this.frame = frame;
	}

	public void setSocket(Socket socket) { this.frame.setSocket(socket); }
	public Socket getSocket(){ return this.frame.getSocket(); }

	protected ObjectInputStream getOIS() {
		return frame.getOIS();
	}
	protected ObjectOutputStream getOOS() {
		return frame.getOOS();
	}


	@Override
	public void definedBehavior(CodeType type, Data data) {
		switch (type){
			case LOGIN_STATUS -> frame.setInnerPanel(type);
		}
	}
}
