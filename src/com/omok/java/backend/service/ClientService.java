package com.omok.Java.Backend.Service;

import com.omok.Java.Backend.Manager.ServerStreamManager;
import com.omok.Java.Backend.Manager.StreamManager;
import com.omok.Java.Data.Data;
import com.omok.Java.Data.UserData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// �������� ����� �Ѱ��ϴ� ����
// ������ �α��ο� �����ϸ� �����ǰ�, �α׾ƿ� �ñ��� �Է��� ó���Ѵ�.
// �� Ŭ������ �ν��Ͻ��� Thread ��ü�� ��ĳ�����ϰ� start �޼ҵ带 ȣ���Ͽ� �����Ѵ�.
public class ClientService implements Runnable {

	private final Socket socket;	// ServerSocket.accept()�� ���� �Ҵ�� ����
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

















