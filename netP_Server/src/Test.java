import com.omok.java.backend.server.Server;
import com.omok.java.data.CodeType;
import com.omok.java.data.user.UserData;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {

		Server server = Server.getInstance();
		server.setServerPort(30000);
		server.start();

		try {

			UserData u1 = new UserData("127.0.0.1", 30000, "user1");
			u1.definedBehavior(CodeType.LOGIN_STATUS);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
