package application;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ConnectionHandler implements Runnable{
	Socket	connection;	
	ConnectionHandler(Socket connection)	{	
		this.connection=connection;	
	}	
	public void run(){	
		DataOutputStream out=null;	
	try	{	
		out	=new DataOutputStream(connection.getOutputStream());	
		out.writeUTF("Hello	Client!!");	
	}	
	catch (IOException	e)	{		
		System.out.println("ERROR Detected!!!");
	}	
	finally	{		
		try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try {
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
	}	
}
