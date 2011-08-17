package com.coen_316;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Afterlogin extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin);
        
     // BUTTON FOR CAL_DOSE;
		Button btncalculatedose = (Button) findViewById(R.id.btncal_dose );
		btncalculatedose.setOnClickListener(this);
		
		//button for sms
		Button btnsms = (Button) findViewById(R.id.btnsms);
		btnsms.setOnClickListener(this);
		
		//button for hlp
		Button btnhelp=(Button) findViewById(R.id.btnhelp);
		btnhelp.setOnClickListener(this);
		
		//button for hlp
		Button btnfile=(Button) findViewById(R.id.btnfile);
		btnfile.setOnClickListener(this);

	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			if(v.getId()==R.id.btncal_dose)
			{
				// CALLS AN ACTIVITY WHICH CALCULATES THE DRUG DOSAGE.
				System.out.print("1234");
				startActivity(new Intent(Afterlogin.this,CalculateDose.class));
				
			}
			if (v.getId()==R.id.btnsms)
			{
				// CALLS A METHOD WHICH SEND THE SMS CONSISTING OF THE GEO COORDINATES
				gps();
				//startActivity(new Intent(Afterlogin.this,SMS.class));
			}
			
			if(v.getId()==R.id.btnexit)
				finish();
			if(v.getId()==R.id.btnhelp)
			{
				startActivity(new Intent(Afterlogin.this,Help.class));
			}
			if(v.getId()==R.id.btnfile)
			{
				ThinClient.main(null);
			}
						
	}

	// THIS METHOD GETS THE GEO CO-ORDINATES AND RETURNS BACK IN THE FORM OF SMS
	private void gps() {
		// TODO Auto-generated method stub
		
			LocationManager locMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	        LocationListener locListener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				
				try{
					if(location!=null)
					{
						System.out.println("\n\nlatitud is ~~~~~~  "+location.getLatitude());
						System.out.println("\n\nlong is ~~~~~~  "+location.getLongitude());
						double lati = location.getLatitude();
						double longi = location.getLongitude();
						GPSSms.main(lati, longi);
					}
					else
					{	
						System.out.println("NA");					
					}
				}//end of try
				catch (Exception e) {
					// TODO: handle exception
				}// end of catch		
			}// end of onlocation changed
        
	
			};// end of location listener

			locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);

        }
}
