package com.omok.java.backend.service;

import com.omok.java.StreamManager;
import com.omok.java.data.Data;
import com.omok.java.data.user.UserData;

import java.io.*;
import java.net.Socket;

// 유저와의 통신을 총괄하는 서비스
// 유저가 로그인에 성공하면 생성되고, 로그아웃 시까지 입력을 처리한다.
// 본 클래스의 인스턴스는 Thread 객체로 업캐스팅하고 start 메소드를 호출하여 실행한다.
public class ClientService implements Runnable {

	private Socket socket;	// ServerSocket.accept()에 의해 할당된 소켓
	private StreamManager streamManager;
	private UserData userData;

	public ClientService(Socket socket)  {
		this.socket = socket;
		this.streamManager = new ServerStreamManager(socket);
	}

	@Override
	public void run() {

	}

	private class ServerStreamManager implements StreamManager {

		private ObjectInputStream fromClient;
		private ObjectOutputStream toClient;

		public ServerStreamManager(Socket socket) {
			try {
				this.fromClient = new ObjectInputStream( new BufferedInputStream( socket.getInputStream() ));
				this.toClient = new ObjectOutputStream( new BufferedOutputStream( socket.getOutputStream() ));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public Data receive() throws IOException, ClassNotFoundException {
			return (Data) fromClient.readObject();
		}
		@Override
		public void send(Data o) throws IOException {
			toClient.writeObject(o);
		}

	}

}

















