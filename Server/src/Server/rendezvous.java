package Server;

import java.net.*;
import java.io.*;

public class rendezvous {
		
	Socket clientsocket1 = null;
	ServerSocket clientsocket2 = null;
	
	void conversation(){
		  try{
			  
		  System.out.println("Rendezvous with client");
		  clientsocket2 = new ServerSocket(7777);
		  clientsocket1 = clientsocket2.accept();  
		  
		
		  
		  
		  
	     //Stream Readers for the socket		  
		  BufferedReader br = new BufferedReader(new InputStreamReader(clientsocket1.getInputStream()));
		  PrintWriter out = new PrintWriter(clientsocket1.getOutputStream(),true);
		 
		 
		//Sending notfication to client
		 out.write("You have a file .Please Inform whether you want to receive it now or not");
		 out.flush();
		 
		 String response = null;
		 
		 response = br.readLine();
		 
		 if(response.equals("no")||response.equals("n"))  System.exit(1);		
		 System.out.println(response);
		 System.out.println("Sending the file");
		 clientsocket1.close();
		 clientsocket2.close();
		  }
		  catch(UnknownHostException ue){
			  
			  System.out.println(ue.getMessage());
			  System.exit(1);  
		  }
		  catch(IOException ie){
			  
			  System.out.println(ie.getMessage());
			  System.exit(1);
		  }
		  
		}
	
	

}
