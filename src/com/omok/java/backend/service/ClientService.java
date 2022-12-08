package com.omok.Java.Backend.Service;

import com.omok.Java.Backend.Manager.ServerStreamManager;
import com.omok.Java.Backend.Manager.StreamManager;
import com.omok.Java.Data.Data;
import com.omok.Java.Data.UserData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// 유저와의 통신을 총괄하는 서비스
// 유저가 로그인에 성공하면 생성되고, 로그아웃 시까지 입력을 처리한다.
// 본 클래스의 인스턴스는 Thread 객체로 업캐스팅하고 start 메소드를 호출하여 실행한다.
public class ClientService implements Runnable {

	private final Socket socket;	// ServerSocket.accept()에 의해 할당된 소켓
	private final StreamManager streamManager;
	private UserData userData;

	public ClientService(Socket socket, StreamManager streamManager)  {
		this.socket = socket;
		this.streamManager = streamManager;
	}

	@Override
	public void run() {
		while(true){

		}
	}

}

















