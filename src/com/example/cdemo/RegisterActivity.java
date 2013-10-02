package com.example.cdemo;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.cdemoutil.CConstantsInter;

import android.os.Bundle;
import android.widget.Button;

public class RegisterActivity extends SherlockActivity {

	Button cmdRegister;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setTheme(CConstantsInter.APP_THEME);
	    
	    setContentView(R.layout.activity_register);
	    cmdRegister = (Button) findViewById(R.id.btn0);
	}

}
