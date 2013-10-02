package com.chat.service;

import java.net.ServerSocket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ChatService extends Service {

	ServerSocket serverSocket;

	@Override
	public void onCreate() {
		super.onCreate();

	}

	@Override
	public IBinder onBind(Intent arg0) {

		return null;
	}

}
