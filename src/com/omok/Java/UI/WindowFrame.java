package com.omok.Java.UI;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.UI.Panel.Structure.InnerPanel;

import javax.swing.*;
import java.awt.*;

// create new window which contains a panel
// all objects which extends WindowFrame should override function run() from interface Runnable
public abstract class WindowFrame extends JFrame implements DataHandler {

	private Container container;
	private InnerPanel innerPanel;

	public WindowFrame(String title) {
		super(title);
		this.container = getContentPane();
		this.innerPanel = null;
	}

	public InnerPanel getInnerPanel() {
		return innerPanel;
	}

	public void setInnerPanel(InnerPanel innerPanel) {
		if (this.innerPanel != null) {
			remove(this.innerPanel);
		}
		container.add(innerPanel);
		this.innerPanel = innerPanel;
		this.innerPanel.setVisible(true);
		repaint();
	}

	public abstract void setInnerPanel(CodeType codeType);
}
