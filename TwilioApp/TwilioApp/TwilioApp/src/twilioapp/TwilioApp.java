/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package twilioapp;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import java.net.*;


public class TwilioApp  {
/* Twilio REST API version */
public static ServerSocket twiliosocket = null;
public static Socket androidsocket = null;
public static final String APIVERSION = "2010-04-01";

public static void main(String args[]) throws IOException {
	
	// TODO Auto-generated method stub
	/* Instantiate a new Twilio Rest Client */

		
	// Listening to a port number 
	try {
		twiliosocket = new ServerSocket(7777);
		
		for(;;){
		androidsocket = twiliosocket.accept();
		Thread androidclient = new Twilioclient(androidsocket);
		      androidclient.start(); 
    	       }
		
	      }	
	
	catch(UnknownHostException ue){
		System.err.println("Connection Refused");
		System.exit(1);
		         	             }
	
	catch (IOException e){
		System.err.println("Connection Refused");
		System.exit(1);
	                     }
	
	twiliosocket.close();	

    }
 }


 class Twilioclient extends Thread{	
	 public static final String APIVERSION = "2010-04-01";
	 public static final String ACCOUNTSID = "AC12909decc1852bd05e127a8844bd6ec3";
	 public static final String AUTHTOKEN = "886e0c63b19c7922bfbc802b0b40aaab";
	 String fileconnection = "C:\\Users\\rohitdumbre86\\Android\\hello.txt";
	 Socket androidsocket;
	 BufferedReader input = null;
	 String sushilno;
	 Twilioclient(Socket sock){
		 this.androidsocket = sock;
		 
	 }
	 
	public void run(){ 
	TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN, null);
	
	try{
		
		
	BufferedReader input = new BufferedReader ( new InputStreamReader(androidsocket.getInputStream()));
	
	sushilno = input.readLine();
	System.out.println(sushilno);
	
	
	 	
 	//Closing the connection
 	androidsocket.close();
	
	}
	
	catch(UnknownHostException ue){
		System.err.println("Connection Refused");
		System.exit(1);
		         	             }
	
	catch (IOException e){
		System.err.println("Connection Refused");
		System.exit(1);
	                     }
	String sushilnumber="408-504-0107";
	
	//	while(sushilno==null)	;
	//build map of server admins
	Map<String,String> admins = new HashMap<String,String>();
	admins.put(sushilnumber, "Sushil");

	// Iterate over all our server admins
	for (Map.Entry<String, String> entry : admins.entrySet()) {
	// Send a new outgoinging SMS by POST’ing to the SMS resource */
	// YYY-YYY-YYYY must be a Twilio validated phone number

	//build map of post parameters
	Map<String,String> params = new HashMap<String,String>();
	params.put("From", "(415) 599-2671");
	params.put("To", entry.getKey());
	params.put("Body", sushilno);

	TwilioRestResponse response;
	try {
		// REST GET
	response = client.request("/"+APIVERSION+"/Accounts/"+client.getAccountSid()+"/SMS/Messages", "POST", params);

	if(response.isError())
	System.out.println("Error send SMS: "+response.getHttpStatus()+"\n"+response.getResponseText());
	
	else {
	System.out.println("Success sending SMS: " + response.getResponseText());
	}
	} catch (TwilioRestException e) {
	e.printStackTrace();
	}
	}
	}

}
