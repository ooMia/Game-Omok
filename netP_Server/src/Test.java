import com.omok.java.backend.server.Server;
import com.omok.java.data.user.UserData;
import com.omok.java.frontend.WindowFrame;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {

		Server server = Server.getInstance();
		server.setServerPort(30000);
		server.start();

		try {
			UserData u1 = new UserData("127.0.0.1", 30000, "u1");
			UserData u2 = new UserData("127.0.0.1", 30000, "u2");
			UserData u3 = new UserData("127.0.0.1", 30000, "u3");
			UserData u4 = new UserData("127.0.0.1", 30000, "u4");

			WindowFrame wf1 = new WindowFrame();
			WindowFrame wf2 = new WindowFrame();
			WindowFrame wf3 = new WindowFrame();
			WindowFrame wf4 = new WindowFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
