package com.omok.Java.Backend.Service;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientService implements Runnable, DataHandler
{
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public void run() {

	} // run

	@Override
	public void sendData(CodeType codeType, Data data) {

	}

	@Override
	public void onReceiveData(Data data) {

	}

	//		public void Login() {		}
	//		public void Logout() {		}
	//		public void WritePrivate(String msg) {		}
	//		public void WriteChatMsg(Data data) {		}
	//		public Data ReadChatMsg() {		}
}