package com.omok.Java.Backend.Service;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;

public interface DataHandler {
	void sendData(CodeType codeType, Data data);
	void onReceiveData(Data data);
}
