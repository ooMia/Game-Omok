package com.omok.Java.Backend.Manager;

import com.omok.Java.Data.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientStreamManager implements StreamManager {

	private ObjectInputStream fromServer;
	private ObjectOutputStream toServer;

	public ClientStreamManager(
			Socket socket,
			ObjectInputStream fromServer,
			ObjectOutputStream toServer) throws IOException {
		this.fromServer = fromServer;
		this.toServer = toServer;
	}

	@Override
	public Data receive() throws IOException, ClassNotFoundException {
		return (Data) fromServer.readObject();
	}
	@Override
	public void send(Data data) throws IOException {
		toServer.writeObject(data);
	}

	@Override
	public ObjectInputStream getOIS() {
		return fromServer;
	}

	@Override
	public ObjectOutputStream getOOS() {
		return toServer;
	}

}