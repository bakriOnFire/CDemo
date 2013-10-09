package com.example.cdemo;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.cdemo.R;
import com.example.cdemoutil.CConstantsInter;

public class LoginActivity extends SherlockActivity implements OnClickListener {

	Button cmdLogin;
	Button cmdRegister;
	EditText edtUsername;
	EditText edtPassword;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(CConstantsInter.APP_THEME);
		setContentView(R.layout.activity_login);
		
		edtUsername = (EditText) findViewById(R.id.edt0);
		edtPassword = (EditText) findViewById(R.id.edt1);
		
		cmdLogin = (Button) findViewById(R.id.btn0);
		cmdLogin.setOnClickListener(this);
		cmdRegister = (Button) findViewById(R.id.btn1);
		cmdRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == cmdLogin) {
			if(edtUsername.getText().toString().equalsIgnoreCase("")) {
				edtUsername.setError(getResources().getString(R.string.login_edittext_username_mandatory));
			} else if(edtPassword.getText().toString().equalsIgnoreCase("")) {
				edtPassword.setError(getResources().getString(R.string.login_edittext_password_mandatory));
			} else {
				
			}
		} else if (v == cmdRegister) {
			Intent intRegister = new Intent(this, RegisterActivity.class);
			startActivityForResult(intRegister, CConstantsInter.LOGIN_ACTIVITY_RESULT);
		}
	}

}
