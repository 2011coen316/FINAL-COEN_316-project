package Server;

import java.io.*;
import java.net.*;

class AndroidClient{
	
	public static void main(String args[]){
		
		try{
			
			//Wait until there is file in the folder
			String filefolder = "C:\\Users\\rohitdumbre86\\Android\\";
			File f = new File(filefolder);
			int presense = 0;
			while(presense==0){
			    File[] f1 = f.listFiles();
				//System.out.println(f1.length+"");
				presense = f1.length;
			}			
			
		//First Talking with 	
		//Rendezvous with client
		rendezvous rc = new rendezvous();
		rc.conversation();	
			
		ServerSocket android = null;
		//Acception a connection
		android = new ServerSocket(7777);
		String fileconnection = "C:\\Users\\rohitdumbre86\\Android\\hello.txt";
		
		
		
	    // Creating a socket for the client
		Socket clientsocket = null;
	 	clientsocket = android.accept();
	 	
	 	if(clientsocket!=null){
	 		System.out.println("Connection accepted");
	 		
	 	}
	 	
	 	else {System.exit(1);}
	 	
	 	
	 			
		//File Input Stream 
		File file = new File(fileconnection);
		FileInputStream fin = new FileInputStream(file);
				
		//Converting File Input Stream into data input stream
	 	DataInputStream dis = new DataInputStream(fin);
	 	
	 	//Conversion from data to bufferedInput stream
	 	BufferedReader br = new BufferedReader(new InputStreamReader(dis));
	 	
	 	//Streams for file
	 	PrintWriter out = new PrintWriter(clientsocket.getOutputStream(),true);
	 	
	 	
	 	//Reading the line 
	 	
	 	String strline;
	 	while((strline=br.readLine())!=null)
	 	{  
	 		
	 		System.out.println(strline);
	 		
	 		out.write(strline);
	 		out.flush();
	 		
	 	}
	 	
		//Closing the connection
	 	clientsocket.close();
		android.close();
		
		   }
		
		catch(UnknownHostException ue) {
		System.out.println(ue.getMessage());
		System.exit(1);	
		
		}
		catch(IOException ie){
		System.out.println(ie.getMessage());
		System.exit(1);	
		}
		
	}
	
}