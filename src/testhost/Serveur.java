package testhost;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//source Open Classroom
public class Serveur {
	public static void main(String[] args) {
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		try {
			socketserver = new ServerSocket(2017);
			socketduserveur = socketserver.accept(); 
			System.out.println("un client connecté");
			socketserver.close();
			socketduserveur.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
