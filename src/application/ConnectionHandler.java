package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

class ConnectionHandler extends Thread{
	Scanner scn = new Scanner(System.in); 
    private String name; 
    final DataInputStream dis; 
    final DataOutputStream dos; 
    Socket s; 
    boolean isloggedin; 
      
    // constructor 
    public ConnectionHandler(Socket s, String name, 
                            DataInputStream dis, DataOutputStream dos) { 
        this.dis = dis; 
        this.dos = dos; 
        this.name = name; 
        this.s = s; 
        this.isloggedin=true; 
    } 
  
    @Override
    public void run() { 
  
        String received; 
        while (true)  
        { 
            try
            { 
                // receive the string 
                received = dis.readUTF(); 
                  
                System.out.println(received); 
                  
                if(received.equals("logout")){ 
                    this.isloggedin=false; 
                    this.s.close(); 
                    break; 
                } 
                 /* 
                // break the string into message and recipient part 
                StringTokenizer st = new StringTokenizer(received, "#"); 
                String MsgToSend = st.nextToken(); 
                String recipient = st.nextToken(); 
  
                // search for the recipient in the connected devices list. 
                // ar is the vector storing client of active users 
            
                for (ConnectionHandler mc : Server.ar)  
                { 
                    // if the recipient is found, write on its 
                    // output stream 
                    if (mc.name.equals(recipient) && mc.isloggedin==true)  
                    { 
                        mc.dos.writeUTF(this.name+" : "+MsgToSend); 
                        break; 
                    } 
                } 
                */
            } catch (IOException e) { 
                  
                e.printStackTrace(); 
            } 
              
        } 
        try
        { 
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    }
	
	
	
	/*
	 * version 2-------------
	private final Socket connection;
	public ConnectionHandler(Socket clientSocket) {
		this.connection=clientSocket;
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		DataOutputStream out=null;
		try {
			out=new DataOutputStream(connection.getOutputStream());			
		out.writeUTF("Hello Client !!");
		}
		catch(IOException e) {
			System.out.println("Could not connect!!");
		}
		finally {
			try {
			out.close();
			connection.close();}
			catch(IOException e){
				System.out.println("Could not close");
			}
		}
		*/
		/*
		try {
			handleclientSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
	 * version 2-------------
	}*/
	/*
	private void handleclientSocket() throws IOException,InterruptedException {
		// TODO Auto-generated method stub
	OutputStream outstream=	this.clientSocket.getOutputStream();	
	for(int i=0;i<10;i++) {
		outstream.write(("Time now is "+new Date()+"\n").getBytes());
		Thread.sleep(1000);
	}
	this.clientSocket.close();
	}
	*/
}
