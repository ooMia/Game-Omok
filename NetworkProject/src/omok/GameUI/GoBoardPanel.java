package omok.GameUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class GoBoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 바둑판 이미지
	private Image board;
	
	// 바둑알
	private ImageIcon blackStoneIcon;
	private ImageIcon whiteStoneIcon;
	private ArrayList<Stone> stoneList = new ArrayList<Stone>();
	private JLabel bStone;
	private JLabel wStone;
	
	private int[] gridXPos = {24, 55, 86, 118, 149, 180, 211, 242, 274, 305, 337, 368, 400, 431, 462, 493, 524, 556, 587};
	private int[] gridYPos = {20, 50, 80, 109, 139, 169, 199, 229, 258, 288, 318, 348, 378, 407, 437, 467, 497, 527, 556};
	private int[][] stonePos = new int[19][19];
	
	public GoBoardPanel() {
		this.setPreferredSize(new Dimension(613, 577));
		this.setLayout(null);
		ImageIcon boardIcon = new ImageIcon("./image/boardt.jpg");
		board = boardIcon.getImage();
		
		blackStoneIcon = new ImageIcon("./image/blackstonet.png");
		whiteStoneIcon = new ImageIcon("./image/whitestonet.png");
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		bStone = new JLabel();
		bStone.setIcon(blackStoneIcon);
		wStone = new JLabel();
		wStone.setIcon(whiteStoneIcon);
		
		addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                placeStone(e.getPoint());
            }
        });
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
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
	    	g.drawImage(board, width, height, 613, 577, null);
	    }
	}
	public void placeStone(Point p) {
		Point temp = calculatePos(p);
		
		if(temp != null) { 
			int i = stoneList.size() % 2;

			checkRule33();
			
			JLabel tempStone = new JLabel();
			// 흑돌 백돌
			if(i == 0)
				tempStone.setIcon(blackStoneIcon);
			else
				tempStone.setIcon(whiteStoneIcon);
			
			tempStone.setBounds(gridXPos[temp.x] - 12, gridYPos[temp.y] - 12, 25, 25);
			Stone stone = new Stone(temp, stoneList.size()+1, tempStone);
			stoneList.add(stone);
			if(i == 0)
				stonePos[temp.x][temp.y] = 1; //black
			else
				stonePos[temp.x][temp.y] = 2; //white
			this.add(tempStone);
			this.revalidate();
			this.repaint();
			
			checkFinish(temp.x, temp.y);
		}
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
	
	private void gameFinish() {
		System.out.println("f");
	}
}
