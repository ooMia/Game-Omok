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
		System.out.println(this.toString() + "\tSTART");

		System.out.println(this.socket.toString());

		try {
//			toServer.writeObject("Hello, World!");
			String o = (String) fromServer.readObject();
			System.out.println(this.socket.toString() + " : " + o);
			System.out.println(o.getClass().toString());

//			this.socket.close();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(this.toString() + "\tEND");
	}
}