package com.omok.Java.UI.Panel.Gameroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class GoBoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 바둑판 이미지
	private Image board;

	// 바둑알
	private ImageIcon blackStoneIcon;
	private ImageIcon whiteStoneIcon;
	private ImageIcon blackStonetrIcon;
	private ImageIcon whiteStonetrIcon;
	private ArrayList<Stone> stoneList = new ArrayList<Stone>();
	private JLabel bStone;
	private JLabel wStone;
	private JLabel tStone;

	private boolean isStart;
	private boolean playerTurn;
	private MouseAdapter mouseAdapter;

	private int[] gridXPos = {24, 55, 86, 118, 149, 180, 211, 242, 274, 305, 337, 368, 400, 431, 462, 493, 524, 556, 587};
	private int[] gridYPos = {20, 50, 80, 109, 139, 169, 199, 229, 258, 288, 318, 348, 378, 407, 437, 467, 497, 527, 556};
	private int[][] stonePos = new int[19][19];

	public GoBoardPanel(boolean isObserve) {
		this.setPreferredSize(new Dimension(613, 577));
		this.setLayout(null);
		ImageIcon boardIcon = new ImageIcon("./image/boardt.jpg");
		board = boardIcon.getImage();

		blackStoneIcon = new ImageIcon("./image/blackstonet.png");
		whiteStoneIcon = new ImageIcon("./image/whitestonet.png");
		blackStonetrIcon = new ImageIcon("./image/blackstonetr.png");
		whiteStonetrIcon = new ImageIcon("./image/whitestonetr.png");

		setBorder(BorderFactory.createLineBorder(Color.black));

		bStone = new JLabel(blackStoneIcon);
		//bStone.setIcon(blackStoneIcon);
		wStone = new JLabel();
		wStone.setIcon(whiteStoneIcon);

		isStart = false;
		playerTurn = false;

		tStone = new JLabel();

		if(!isObserve) {
			mouseAdapter = new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(playerTurn)
						placeStone(calculatePos(e.getPoint()));
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					if(playerTurn)
						tStone.setVisible(true);
				}
				@Override
				public void mouseMoved(MouseEvent e) {
					if(playerTurn) {
						if(!tStone.isVisible())
							tStone.setVisible(true);
						translucentStone(calculatePos(e.getPoint()), tStone);
					}
				}
				@Override
				public void mouseExited(MouseEvent e) {
					tStone.setVisible(false);
				}
			};
			this.addMouseListener(mouseAdapter);
			this.addMouseMotionListener(mouseAdapter);
		}
	}

	public void gameStart() {
		if(isStart)
			return;

		// 데이터 지우기
		stoneList.clear();
		for(int i=0;i<19;i++)
			Arrays.fill(stonePos[i], 0);

		this.removeAll();
		this.add(tStone);
		this.revalidate();
		this.repaint();
		isStart = true;
		// need master or slave from data for who's turn
		playerTurn = true;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		super.paintComponent(g2);
		if (board != null)
		{
			int x = getWidth();
			int y = getHeight();
			int width = x;
			int height = y;

			if(x > 613) {
				width = (x - 613)/2;
			}
			if(y > 577) {
				height = (y - 577)/2;
			}
			g2.drawImage(board, width, height, 613, 577, null);
		}
	}

	public void translucentStone(Point p, JLabel s) {
		if(p == null)
			return;

		int i = stoneList.size() % 2;

		// 흑돌 백돌
		if(i == 0)
			s.setIcon(blackStonetrIcon);
		else
			s.setIcon(whiteStonetrIcon);

		s.setBounds(gridXPos[p.x] - 12, gridYPos[p.y] - 12, 25, 25);

		this.revalidate();
		this.repaint();
	}

	public void placeStone(Point p) {
		if(p == null)
			return;

		int i = stoneList.size() % 2;

		checkRule33();

		JLabel tempStone = new JLabel();
		// 흑돌 백돌
		if(i == 0)
			tempStone.setIcon(blackStoneIcon);
		else
			tempStone.setIcon(whiteStoneIcon);

		tempStone.setBounds(gridXPos[p.x] - 12, gridYPos[p.y] - 12, 25, 25);
		Stone stone = new Stone(p, stoneList.size()+1, tempStone);
		stoneList.add(stone);
		if(i == 0)
			stonePos[p.x][p.y] = 1; //black
		else
			stonePos[p.x][p.y] = 2; //white
		this.add(tempStone);
		this.revalidate();
		this.repaint();

		checkFinish(p.x, p.y);
		// playerTurn = false;
	}

	private Point calculatePos(Point p) {
		int x, y, tempX, tempY, gridX, gridY;
		x = (int)((p.getX() - 24)/31.27777);
		y = (int)((p.getY() - 20)/29.77777);

		// x위치 계산
		if(x < 0)
			x = 0;
		else if(x > 18)
			x = 18;

		tempX = (int)p.getX() - gridXPos[x];
		if(tempX > 15 && x < 18) {
			gridX = x + 1;
		} else {
			gridX = x;
		}

		// y위치 계산
		tempY = (int)p.getY() - gridYPos[y];
		if(tempY > 14 && y < 18) {
			gridY = y + 1;
		} else {
			gridY = y;
		}

		// 돌이 있는지 체크
		if(stonePos[gridX][gridY] > 0) {
			return null;
		}

		Point temp = new Point(gridX, gridY);
		return temp;
	}

	private void checkRule33() {

	}

	private void checkFinish(int x, int y) {
		// 가로 확인
		int count = 1;
		for(int i = x+1; i <= 18; i++) {
			if(stonePos[i][y] == stonePos[x][y])
				count++;
			else
				break;
		}
		for(int i = x-1; i >= 0; i--) {
			if(stonePos[i][y] == stonePos[x][y])
				count++;
			else
				break;
		}
		if(count == 5) {
			gameFinish();
			return;
		}
		//세로확인
		count = 1;
		for(int i = y+1; i <= 18; i++) {
			if(stonePos[x][i] == stonePos[x][y])
				count++;
			else
				break;
		}
		for(int i = y-1; i >= 0; i--) {
			if(stonePos[x][i] == stonePos[x][y])
				count++;
			else
				break;
		}
		if(count == 5) {
			gameFinish();
			return;
		}
		//대각확인
		count = 1;
		for(int i = x+1,k = y-1; i <= 18 && k >= 0; i++,k--) {
			if(stonePos[i][k] == stonePos[x][y])
				count++;
			else
				break;
		}
		for(int i = x-1,k = y+1; i >= 0 && k <= 18; i--,k++) {
			if(stonePos[i][k] == stonePos[x][y])
				count++;
			else
				break;
		}
		if(count == 5) {
			gameFinish();
			return;
		}

		count = 1;
		for(int i = x-1,k = y-1; i >= 0 && k >= 0; i--,k--) {
			if(stonePos[i][k] == stonePos[x][y])
				count++;
			else
				break;
		}
		for(int i = x+1,k = y+1; i <= 18 && k <= 18; i++,k++) {
			if(stonePos[i][k] == stonePos[x][y])
				count++;
			else
				break;
		}
		if(count == 5) {
			gameFinish();
			return;
		}
	}

	public void gameFinish() {
		playerTurn = false;
		isStart = false;

		System.out.println("f");
	}
}
