package testhost;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	//source Open Classroom
	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket(InetAddress.getLocalHost(),2017);
			System.out.println("Connexion réussi.");
			socket.close();
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
