package com.coen_316;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MedNotTaken  
{
	
	public static void main(String sugar)
	{
		final String phonenumber;
 	   	phonenumber = "Medicine Not Taken";//txtphone.getText().toString();
		
	
		//Create a client socket
		Socket androidsocket = null;
		PrintWriter out1 = null;
		//Creating a connection with the server
		try
		{	
			androidsocket= new Socket("172.16.71.157",7777);
			out1 = new PrintWriter(androidsocket.getOutputStream(), true);
			System.out.println("not taken");				
		}
		
		catch (UnknownHostException ue){}					
		catch (Exception e)
		{		
			System.err.println("Unknown server");
			e.printStackTrace();
		}
       try
       {   //out1.write(SignUp.phone);      
		   out1.write(phonenumber);
		   out1.flush();
		   out1.write(sugar);
		   androidsocket.close();
       }
		
       catch(Exception e)
	   {
	   		System.err.println("Unknown server");
	   		e.printStackTrace();
	   	}
		
    }
	 
}
