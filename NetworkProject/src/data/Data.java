package data;

import java.io.Serializable;

public interface Data extends Serializable {
	// code ���� ���� �ݹ� �Լ� ȣ��
	Object definedBehavior(CodeType code);

	// code ���� ���� data �ٿ�ĳ���� �� ��ȯ
	Data getUnpackedData(CodeType code, Data data);
}
