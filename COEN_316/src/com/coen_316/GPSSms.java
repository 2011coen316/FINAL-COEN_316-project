package com.coen_316;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GPSSms {

		public static void main(double latitude, double longitude)
		{
			
			final String phonenumber;
	 	   	phonenumber = "GPS location of user";//txtphone.getText().toString();
			
		
			//Create a client socket
			Socket androidsocket = null;
			PrintWriter out1 = null;
			//Creating a connection with the server
			try
			{	
				androidsocket= new Socket("172.16.71.157",7777);
				out1 = new PrintWriter(androidsocket.getOutputStream(), true);
				System.out.println("taken");				
			}
			
			catch (UnknownHostException ue){}					
			catch (Exception e)
			{		
				System.err.println("Unknown server");
				e.printStackTrace();
			}
	       try
	       {         
			   out1.write(phonenumber);
			   //out1.write(System.out.println());
			   String a= Double.toString(latitude);
			   String b = Double.toString(longitude);
			   out1.write( "Latitude is : ");
			   out1.write(a);
			   out1.write(" "+ "longitude is : ");
			   out1.write(b);
			   out1.flush();
			   androidsocket.close();
	       }
			
	       catch(Exception e)
		   {
		   		System.err.println("Unknownsadasda server");
		   		e.printStackTrace();
		   	}
					
		}
	
}
