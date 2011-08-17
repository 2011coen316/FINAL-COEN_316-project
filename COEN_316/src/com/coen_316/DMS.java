package com.coen_316;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class DMS extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnLogin;
        Button btnCancel;
        Button btnsignup;
        
        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.btncancel);
        btnCancel.setOnClickListener(this);
        btnsignup = (Button) findViewById(R.id.butt_signup);
        btnsignup.setOnClickListener(this);
    
    }// main class    
    
	    @Override
		public void onClick(View v) {
		if(v.getId() == R.id.btnlogin)
		{
			EditText etUsername;
	        EditText etPassword;
	        etUsername = (EditText) findViewById(R.id.txtuname);
	        etPassword = (EditText) findViewById(R.id.txtpassword);
			String uname = etUsername.getText().toString();
			String password = etPassword.getText().toString();
	     
			if(uname.equals("sushil") && password.equals("123"))
			{
				startActivity(new Intent(DMS.this, Afterlogin.class));
				
			}
		}
		
		else if (v.getId() == R.id.butt_signup)
		{
			startActivity(new Intent(DMS.this, SignUp.class));
		}
		
	}//onclick view

}