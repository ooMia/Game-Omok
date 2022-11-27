package com.omok.java;

import com.omok.java.data.Data;

import java.io.IOException;

public interface StreamManager {
	Data receive() throws IOException, ClassNotFoundException;
	void send(Data o) throws IOException;
}