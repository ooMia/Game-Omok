package com.omok.Java.UI.Panel.Structure;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;

// only one InnerPanel can be shown above for each WindowFrame
// can change InnerPanel by calling function setView() in WindowFrame
public abstract class InnerPanel extends JPanel implements DataHandler {
	protected WindowFrame windowFrame;

	public InnerPanel(WindowFrame windowFrame) {
		this.windowFrame = windowFrame;
	}

//	public void setWindowFrame(WindowFrame windowFrame){
//		this.windowFrame=windowFrame;
//	}
}
