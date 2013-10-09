package com.example.cdemo;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.cdemoutil.CConstantsInter;
import com.example.cdemoutil.DatabaseInter;
import com.example.cdemoutil.LocalDBOperation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends SherlockActivity {
	
	LocalDBOperation db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(CConstantsInter.APP_THEME);
		
		db = new LocalDBOperation(this, DatabaseInter.DATABASE_NAME, null,
				DatabaseInter.DATABASE_VERSION);
		
		String[][] userInfo = db.selectData(DatabaseInter.TABLE_USER_INFO.NAME, null);
		if(userInfo == null) {
			Intent intLogin = new Intent(this, LoginActivity.class);
			startActivityForResult(intLogin, CConstantsInter.MAIN_ACTIVITY_RESULT);
			finish();
		}
	}

}
