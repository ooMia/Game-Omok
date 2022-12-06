package omok;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
			
	public static void main(String[] args) {
		
		String ipAddr = "127.0.0.1";
		String portNo = "30000";
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f;
				f = new MainFrame(ipAddr, portNo);
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 프로세스 남지 않게 종료
			}
		});
		
		//f.setMinimumSize(f.getMinimumSize());
		//f.setSize(new Dimension(1000, 800));
	}
}

