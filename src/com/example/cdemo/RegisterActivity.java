package com.example.cdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.cdemoutil.CConstantsInter;

public class RegisterActivity extends SherlockActivity implements OnClickListener {

	EditText[] edt;
	Button cmdRegister;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setTheme(CConstantsInter.APP_THEME);
	    setContentView(R.layout.activity_register);
	    
	    edt = new EditText[6];
	    edt[0] = (EditText) findViewById(R.id.edt0);
	    edt[1] = (EditText) findViewById(R.id.edt1);
	    edt[2] = (EditText) findViewById(R.id.edt2);
	    edt[3] = (EditText) findViewById(R.id.edt3);
	    edt[4] = (EditText) findViewById(R.id.edt4);
	    edt[5] = (EditText) findViewById(R.id.edt5);
	    cmdRegister = (Button) findViewById(R.id.btn0);
	    cmdRegister.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v == cmdRegister) {
			ArrayList<String> userData = new ArrayList<String>();
			for(int i = 0; i < edt.length; i++) {
				if(edt[i].getText().toString().equalsIgnoreCase("")) {
					edt[i].setError(getResources().getString(R.string.register_edittext_mandatory));
					if(!userData.isEmpty()) {
						userData.clear();
					}
					return;
				}
				userData.add(edt[i].getText().toString());
			}
		}
	}
	
	

}
