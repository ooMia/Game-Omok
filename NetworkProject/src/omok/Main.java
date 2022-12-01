package omok;

import javax.swing.JFrame;

public class Main {
			
	public static void main(String[] args) {
		JFrame f;
		String ipAddr = "127.0.0.1";
		String portNo = "30000";
		f = new MainFrame(ipAddr, portNo);
		f.setVisible(true);
		//f.setMinimumSize(f.getMinimumSize());
		//f.setSize(new Dimension(1000, 800));
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 프로세스 남지 않게 종료
	}
}

