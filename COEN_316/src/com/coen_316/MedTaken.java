package com.coen_316;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MedTaken  
{
	
	public static void main(String insulin, String metformin, String sugar)
	{
		final String phonenumber;
 	   	phonenumber = "Medicine Taken";//txtphone.getText().toString();
		
	
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
    	   //out1.write(SignUp.phone);
		   out1.write(phonenumber);
		   //out1.write(System.out.println());
		   out1.write( "Sugar level: ");
		   out1.write(sugar);
		   out1.write(" "+ "Insulin Dose suggested value : ");
		   out1.write(insulin);
		   out1.write(" " + "Metformin Drug Dose suggested value : ");
		   out1.write(metformin);
		   
		   out1.flush();
		   androidsocket.close();
       }
		
       catch(Exception e)
	   {
	   		System.err.println("Unknown server");
	   		e.printStackTrace();
	   	}
		
    }
	 
}
