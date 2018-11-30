package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class testserverclient {
	
	 public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			String s=in.readLine();
			Server server=new Server(5000);
			if(s.equals("Server")) {
				server.startServer();
			}
			else{
				Client c=new Client();
				c.chat();
			}
		
	}
}

