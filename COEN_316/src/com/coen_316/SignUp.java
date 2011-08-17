package com.coen_316;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends Activity {

	 public static String phone = null;

	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.signup);
	        
	        Button btnsignup = (Button) findViewById(R.id.btnsignup);
	        btnsignup.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					EditText etname = (EditText) findViewById(R.id.etusername);
					EditText etpass = (EditText) findViewById(R.id.etpassword);
					EditText etphoneno = (EditText) findViewById(R.id.etphoneno_);
					
					phone = etphoneno.getText().toString();   
					
					startActivity(new Intent(SignUp.this, Afterlogin.class));
				}
			});
	        
	        
	 }// end of override oncreate
}
