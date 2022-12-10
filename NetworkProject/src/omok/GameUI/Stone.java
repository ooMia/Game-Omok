package omok.GameUI;

import java.awt.Point;

import javax.swing.JLabel;

public class Stone {
	private Point p;
	private int stoneCnt; // ¼ö¼ø
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
