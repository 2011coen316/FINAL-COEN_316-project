package com.coen_316;


import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SMS extends Activity {

	/** Called when the activity is first created. */
    /*
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        
        Button btnsend_sms = (Button) findViewById(R.id.btnsendsms);
        btnsend_sms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
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
				
			}// end of on click view
		});// end of set on click listener
      }
	*/
	
	
}
