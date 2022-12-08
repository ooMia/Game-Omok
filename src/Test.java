import com.omok.java.backend.server.Server;
import com.omok.java.frontend.ui.Client;
import com.omok.java.frontend.omok.MainFrame;

import javax.swing.*;

public class Test {
	public static void main(String[] args) {

		String host = "127.0.0.1";
		Integer portNum = 30001;


		try {
			new Thread(new Server(portNum)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			new Thread(new Client(host, portNum)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}


		JFrame f;
		f = new MainFrame("127.0.0.1", 30000);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 프로세스 남지 않게 종료


	}
}
