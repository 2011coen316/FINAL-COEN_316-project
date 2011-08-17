package com.coen_316;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThinClient {

	public static void main(String args[]){
		
		
		int portno = 7770;
		try{
		
			// CREATING SOCKET
			Socket client = new Socket("10.0.2.2",portno);
			
			// CREATE AN OUTPUT STREAM FOR THE SOCKET
			PrintWriter out1 = new PrintWriter(client.getOutputStream(),true);
		
			String myresponse ;
		
			myresponse = "Yes";
	  
			// SENDING THE RESPONSE TO THE SERVER WITH THE HELP OF SOCKET
		     out1.write(myresponse);
		     out1.flush();
			
			client.close();
			
		}
		// CATCH BLOCK
		catch(UnknownHostException ue){
			System.out.println(ue.getMessage());
		}
		catch(IOException ue){System.out.println(ue.getMessage());}
		
	}

}
