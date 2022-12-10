package com.omok.Java.UI.Frame;

import com.omok.Java.Backend.Service.DataHandler;
import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.Panel.ServerLogUI;
import com.omok.Java.UI.Panel.Structure.InnerPanel;
import com.omok.Java.UI.WindowFrame;

import javax.swing.*;
import java.awt.*;

public class ServerFrame extends WindowFrame implements DataHandler
{

	public ServerFrame(String title) {
		super(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void setInnerPanel(CodeType codeType) {
		switch (codeType){
			case ON_START -> {
				InnerPanel innerPanel = new ServerLogUI(this);
				setPreferredSize(new Dimension(338, 440));
				setVisible(true);
			}
		}
	}

	@Override
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data) {

	}
}
