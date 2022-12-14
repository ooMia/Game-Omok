package com.omok.Java.Data;

public enum CodeType {



	LOGIN_STATUS	,
	LOGOUT_STATUS	,
	SLEEP_STATUS	,
	WAKEUP_STATUS	,



	GET_LIST_USER	,
	TO_ONE_USER	,
	TO_ALL_USER	,
	TO_OTHERS_USER	,
	TO_EXCEPT_USER	,
	TO_MEMBERS_USER	,
	TO_SOME_USER	,

	GET_LIST_ROOM	,
	CREATE_ROOM	,
	JOIN_ROOM	,
	MODIFY_ROOM	,
	EXIT_ROOM	,
	DESTROY_ROOM	,

	READY_GAME	,
	START_GAME	,
	MODIFY_GAME	,
	SET_MASTER_GAME	,

	SURRENDER_GAME_PLAY,
	SUGGEST_DRAW_GAME_PLAY,
	GET_STACK_STONE_GAME_PLAY,
	PUT_STONE_GAME_PLAY,
	WITHDRAW_STONE_GAME_PLAY,
}
