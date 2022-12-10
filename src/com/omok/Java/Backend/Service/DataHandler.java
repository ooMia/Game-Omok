package com.omok.Java.Backend.Service;

import com.omok.Java.Data.CodeType;
import com.omok.Java.Data.Data;
import com.omok.Java.UI.WindowFrame;

public interface DataHandler {
	void sendData(CodeType codeType, Data data);
	void onReceiveData(Data data, WindowFrame frame);
}
