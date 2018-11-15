package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void create_and_connect() throws IOException{
		ServerSocket me=new ServerSocket(1234);
		while(true) {
			Socket connection =me.accept();
			System.out.println("Connected");
		
		new Thread(new ConnectionHandler(connection)).start();
		}
	}
}
