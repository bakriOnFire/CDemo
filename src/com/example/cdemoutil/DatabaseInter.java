package com.example.cdemoutil;

public interface DatabaseInter {
	String DATABASE_NAME = "CHAT_DB";
	int DATABASE_VERSION = 1;

	public interface TABLE_BUDDY_INFO {
		String TABLE_NAME = "buddies";
		String ID = "id";
		String NAME = "name";
		String PHONE_NO = "phone_no";
		String EMAIL = "email";
		String PHOTO_PATH = "photo_path";
		String ABOUT = "about";
	}

	public interface TABLE_USER_INFO {
		String TABLE_NAME = "user";
		String ID = "id";
		String USR_NAME = "user_name";
		String PASSWORD = "password";
		String NAME = "name";
		String PHONE_NO = "phone_no";
		String EMAIL = "email";
		String PHOTO_PATH = "photo_path";
		String ABOUT = "about";
	}
	
	public interface TABLE_BUDDY_CONVERSATION {
		String TABLE_NAME = "buddy";
		String ID = "id";
		String MESSAGE = "message";
		String PHOTO_PATH = "photo_path";
		String VIDEO_PATH = "video_path";
	}
}
