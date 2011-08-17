package com.coen_316;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculateDose extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatedose);
        
        System.out.print("hello asdasdasdsadasd");
        
     // BUTTON FOR CAL_DOSE;
		Button btncalculatedose = (Button) findViewById(R.id.buttoncalculate);
		btncalculatedose.setOnClickListener(this);

	}
    
    
	@Override
	public void onClick(View v)
	{
		if (v.getId() == R.id.buttoncalculate){
		
			EditText txtnote = (EditText) findViewById(R.id.textnote);
			EditText etinsulin = (EditText) findViewById(R.id.textinsulin);
			EditText etmetformin = (EditText) findViewById(R.id.textmetformin);
			EditText etsugar_level = (EditText) findViewById(R.id.txtsugarlevel);
			String sugar = etsugar_level.getText().toString();
			int sugarl = Integer.parseInt(sugar);
			int flag=0;
			
			if(sugarl <= 120)
			{
				//etinsulin.setInputType(integer );
				etinsulin.setText("6 units");
				etmetformin.setText("1 mg");
				txtnote.setText("Meals has to be taken after the Drugs Dose!!!");
				flag=1;
			}
			
			else if(sugarl >= 120 && sugarl <=140)
			{
				//etinsulin.setInputType(integer );
				etinsulin.setText("8 units");
				etmetformin.setText("1 mg");
				txtnote.setText("Meals has to be taken after the Drugs Dose!!!");
				flag=1;

			}
			
			else if(sugarl >= 141 && sugarl <=200)
			{
				//etinsulin.setInputType(integer );
				etinsulin.setText("10 units");
				etmetformin.setText("1.5 mg");
				txtnote.setText("Meals has to be taken after the Drugs Dose!!!");
				flag=1;
			}
			
			else if(sugarl >= 201 && sugarl <=240)
			{
				//etinsulin.setInputType(integer );
				etinsulin.setText("12 units");
				etmetformin.setText("1.5 mg");
				txtnote.setText("Meals has to be taken after the Drugs Dose!!!");
				flag=1;
			}
			
			else if(sugarl >= 241 && sugarl <=300)
			{
				//etinsulin.setInputType(integer );
				etinsulin.setText("12 units");
				etmetformin.setText("2 mg");
				txtnote.setText("Meals has to be taken after the Drugs Dose!!!");
				flag=1;
			}
			
			else if(sugarl >= 301)
			{
				etinsulin.setText("NA");
				etmetformin.setText("NA");
				txtnote.setText("Please see the Doctor immediately!!!");
				flag=1;
			}
			
			try
			{
				Date d = new Date();
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 00);
				c.set(Calendar.MINUTE,01);
				c.set(Calendar.MILLISECOND,00);
				Boolean b = c.equals(d.getTime()) ;
				if(flag==0 && b )
				{
					// SMS function for not taking medicine
					//startActivity(new Intent(CalculateDose.this, MedNotTaken.class));
					System.out.println("Value of flag is :" + flag);
					MedNotTaken.main(sugar);
				}
				else if(flag==1)
				{
					// SMS function for taking medicine
					//startActivity(new Intent(CalculateDose.this, MedTaken.class));
					System.out.println("Value of flag is :" + flag);
					String insulin = etinsulin.getText().toString();
					String metformin = etmetformin.getText().toString();
					MedTaken.main(insulin,metformin, sugar);
				}
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			finally
			{
				flag=0;
				
			}
		}
	}
}
