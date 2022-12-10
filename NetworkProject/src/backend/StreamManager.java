package backend;

import java.io.IOException;

import data.Data;

public interface StreamManager {
	Data receive() throws IOException, ClassNotFoundException;
	
	void send(Data o) throws IOException;
}
