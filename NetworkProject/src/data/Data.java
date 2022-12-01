package data;

import java.io.Serializable;

public interface Data extends Serializable {
	// code 값에 따라 콜백 함수 호출
	Object definedBehavior(CodeType code);

	// code 값에 따라 data 다운캐스팅 후 반환
	Data getUnpackedData(CodeType code, Data data);
}
