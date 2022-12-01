import com.omok.java.backend.server.Server;
import com.omok.java.frontend.Client;
import com.omok.java.frontend.UserLoginForm;

import java.io.*;
import java.net.Socket;

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

	}
}
