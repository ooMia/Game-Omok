package com.omok.Java.UI.Panel.Gameroom;

import javax.swing.*;
import java.awt.*;

public class Stone {
	private Point p;
	private int stoneCnt; // 수순
	private JLabel label;

	public Stone(Point p, int c, JLabel label) {
		this.p = p;
		this.stoneCnt = c;
		this.label = label;
	}

	public Point getPoint() {
		return p;
	}

	public JLabel getLabel() {
		return label;
	}
}
