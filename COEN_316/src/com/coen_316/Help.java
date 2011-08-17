package com.coen_316;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Help extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        
        TextView tv = (TextView) findViewById(R.id.tvhelp);
        tv.setText("This app aims at calculating the drug dose based on the sugar level" +
        		" Calculate dose calculates the drug dose based on the sugar level and sends an sms to the Dr."+
        		"SMS sends an Emergency sms to the Dr. with the geo coordinate locations"+
        		"File recives reports from the Dr.");
	}

}
