package com.omok.Java.Backend.Manager;

import com.omok.Java.Data.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface StreamManager {
	Data receive() throws IOException, ClassNotFoundException;
	void send(Data o) throws IOException;

	ObjectInputStream getOIS();
	ObjectOutputStream getOOS();
}