package com.omok.Java.UI.Panel.Structure;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;

// only one InnerPanel can be shown above for each WindowFrame
// can change InnerPanel by calling function setView() in WindowFrame
public abstract class InnerPanel extends JPanel implements DataHandler {
	private WindowFrame frame;
	public InnerPanel(WindowFrame frame) {
		this.frame = frame;
	}
}
