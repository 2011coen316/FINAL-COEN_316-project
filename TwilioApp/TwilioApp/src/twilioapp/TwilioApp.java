/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package twilioapp;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;

public class TwilioApp {
/* Twilio REST API version */

public static final String APIVERSION = "2010-04-01";
public static final String ACCOUNTSID = "AC12909decc1852bd05e127a8844bd6ec3";
public static final String AUTHTOKEN = "886e0c63b19c7922bfbc802b0b40aaab";

public static void main(String args[]){

	TwilioApp twapp = new TwilioApp();
	twapp.sendsms();

}

private void sendsms() {
	// TODO Auto-generated method stub
	/* Instantiate a new Twilio Rest Client */
	TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN, null);

	//build map of server admins
	Map<String,String> admins = new HashMap<String,String>();
	admins.put("(408) 504-0107", "Rohit Dumbre");

	// Iterate over all our server admins
	for (Map.Entry<String, String> entry : admins.entrySet()) {
	// Send a new outgoinging SMS by POST�ing to the SMS resource */
	// YYY-YYY-YYYY must be a Twilio validated phone number

	//build map of post parameters
	Map<String,String> params = new HashMap<String,String>();
	params.put("From", "(415) 599-2671");
	params.put("To", entry.getKey());
	params.put("Body", "Hello Anshul, Ping me!!");

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