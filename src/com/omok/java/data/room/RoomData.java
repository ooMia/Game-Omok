package com.omok.java.data.room;

import com.omok.java.data.Data;
import com.omok.java.data.user.UserData;
import com.omok.java.frontend.ui.UI;

import java.util.List;

public abstract class RoomData extends Data {
	UI ui;
	abstract List<UserData> getUserList(UI ui);
}
