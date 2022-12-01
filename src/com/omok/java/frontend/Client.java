package com.omok.java.frontend;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable {

	Socket socket;
	ObjectOutputStream toServer;
	ObjectInputStream fromServer;

	public Client(String host, Integer portNum) throws Exception {
		this.socket = new Socket(host, portNum);

		this.toServer = new ObjectOutputStream( socket.getOutputStream() );
//		System.out.println(this.toString() + " : " + toServer.toString());

		this.fromServer = new ObjectInputStream( socket.getInputStream() );
//		System.out.println(this.toString() + " : " + fromServer.toString());

	}

	@Override
	public void run() {
		System.out.println(this.socket.toString() + "\tSTART");

		try {
//			toServer.writeObject("Hello, World!");
			Object o = fromServer.readObject();
			System.out.println(String.format(
					"%s%s : is%sString, \"%s\"", this.getClass(), this.socket.toString(), (o instanceof String)?"":"Not", o.toString()
			));

//			this.socket.close();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(this.toString() + "\tEND");
	}
}